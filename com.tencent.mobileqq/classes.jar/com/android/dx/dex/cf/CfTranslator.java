package com.android.dx.dex.cf;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.code.Ropper;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.Field;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.RopTranslator;
import com.android.dx.dex.file.ClassDefItem;
import com.android.dx.dex.file.DexFile;
import com.android.dx.dex.file.EncodedField;
import com.android.dx.dex.file.EncodedMethod;
import com.android.dx.dex.file.FieldIdsSection;
import com.android.dx.dex.file.MethodIdsSection;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.DexTranslationAdvice;
import com.android.dx.rop.code.LocalVariableExtractor;
import com.android.dx.rop.code.LocalVariableInfo;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstBoolean;
import com.android.dx.rop.cst.CstByte;
import com.android.dx.rop.cst.CstChar;
import com.android.dx.rop.cst.CstEnumRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstInterfaceMethodRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstShort;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.rop.type.Type;
import com.android.dx.ssa.Optimizer;

public class CfTranslator
{
  private static final boolean DEBUG = false;
  
  private static TypedConstant coerceConstant(TypedConstant paramTypedConstant, Type paramType)
  {
    if (paramTypedConstant.getType().equals(paramType)) {
      return paramTypedConstant;
    }
    switch (paramType.getBasicType())
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new UnsupportedOperationException("can't coerce " + paramTypedConstant + " to " + paramType);
    case 1: 
      return CstBoolean.make(((CstInteger)paramTypedConstant).getValue());
    case 2: 
      return CstByte.make(((CstInteger)paramTypedConstant).getValue());
    case 3: 
      return CstChar.make(((CstInteger)paramTypedConstant).getValue());
    }
    return CstShort.make(((CstInteger)paramTypedConstant).getValue());
  }
  
  private static void processFields(DirectClassFile paramDirectClassFile, ClassDefItem paramClassDefItem, DexFile paramDexFile)
  {
    CstType localCstType = paramDirectClassFile.getThisClass();
    FieldList localFieldList = paramDirectClassFile.getFields();
    int j = localFieldList.size();
    int i = 0;
    while (i < j)
    {
      Field localField = localFieldList.get(i);
      try
      {
        CstFieldRef localCstFieldRef = new CstFieldRef(localCstType, localField.getNat());
        int k = localField.getAccessFlags();
        if (AccessFlags.isStatic(k))
        {
          TypedConstant localTypedConstant = localField.getConstantValue();
          EncodedField localEncodedField = new EncodedField(localCstFieldRef, k);
          paramDirectClassFile = localTypedConstant;
          if (localTypedConstant != null) {
            paramDirectClassFile = coerceConstant(localTypedConstant, localCstFieldRef.getType());
          }
          paramClassDefItem.addStaticField(localEncodedField, paramDirectClassFile);
        }
        for (;;)
        {
          paramDirectClassFile = AttributeTranslator.getAnnotations(localField.getAttributes());
          if (paramDirectClassFile.size() != 0) {
            paramClassDefItem.addFieldAnnotations(localCstFieldRef, paramDirectClassFile, paramDexFile);
          }
          paramDexFile.getFieldIds().intern(localCstFieldRef);
          i += 1;
          break;
          paramClassDefItem.addInstanceField(new EncodedField(localCstFieldRef, k));
        }
        return;
      }
      catch (RuntimeException paramDirectClassFile)
      {
        throw ExceptionWithContext.withContext(paramDirectClassFile, "...while processing " + localField.getName().toHuman() + " " + localField.getDescriptor().toHuman());
      }
    }
  }
  
  private static void processMethods(DirectClassFile paramDirectClassFile, CfOptions paramCfOptions, DexOptions paramDexOptions, ClassDefItem paramClassDefItem, DexFile paramDexFile)
  {
    CstType localCstType = paramDirectClassFile.getThisClass();
    MethodList localMethodList = paramDirectClassFile.getMethods();
    int n = localMethodList.size();
    int j = 0;
    Method localMethod;
    int i;
    boolean bool4;
    int m;
    label150:
    Object localObject1;
    for (;;)
    {
      if (j < n)
      {
        localMethod = localMethodList.get(j);
        try
        {
          localCstMethodRef = new CstMethodRef(localCstType, localMethod.getNat());
          i = localMethod.getAccessFlags();
          bool2 = AccessFlags.isStatic(i);
          bool3 = AccessFlags.isPrivate(i);
          bool4 = AccessFlags.isNative(i);
          bool1 = AccessFlags.isAbstract(i);
          if (localCstMethodRef.isInstanceInit()) {
            break label574;
          }
          if (!localCstMethodRef.isClassInit()) {
            break label613;
          }
        }
        catch (RuntimeException paramDirectClassFile)
        {
          CstMethodRef localCstMethodRef;
          boolean bool2;
          boolean bool3;
          throw ExceptionWithContext.withContext(paramDirectClassFile, "...while processing " + localMethod.getName().toHuman() + " " + localMethod.getDescriptor().toHuman());
        }
        if (!AccessFlags.isSynchronized(i)) {
          break label561;
        }
        m = 0x20000 | i;
        i = m;
        if (bool4) {
          break label593;
        }
        i = m & 0xFFFFFFDF;
        break label593;
        localObject1 = new EncodedMethod(localCstMethodRef, m, (DalvCode)localObject1, AttributeTranslator.getExceptions(localMethod));
        if ((localCstMethodRef.isInstanceInit()) || (localCstMethodRef.isClassInit()) || (bool2) || (bool3))
        {
          paramClassDefItem.addDirectMethod((EncodedMethod)localObject1);
          localObject1 = AttributeTranslator.getMethodAnnotations(localMethod);
          if (((Annotations)localObject1).size() != 0) {
            paramClassDefItem.addMethodAnnotations(localCstMethodRef, (Annotations)localObject1, paramDexFile);
          }
          localObject1 = AttributeTranslator.getParameterAnnotations(localMethod);
          if (((AnnotationsList)localObject1).size() != 0) {
            paramClassDefItem.addParameterAnnotations(localCstMethodRef, (AnnotationsList)localObject1, paramDexFile);
          }
          paramDexFile.getMethodIds().intern(localCstMethodRef);
          j += 1;
          continue;
          label272:
          if (paramCfOptions.positionInfo == 1) {
            break label626;
          }
        }
      }
    }
    label561:
    label574:
    label593:
    label613:
    label617:
    label619:
    label626:
    for (boolean bool1 = true;; bool1 = false)
    {
      ConcreteMethod localConcreteMethod = new ConcreteMethod(localMethod, paramDirectClassFile, bool1, paramCfOptions.localInfo);
      localObject1 = DexTranslationAdvice.THE_ONE;
      Object localObject3 = Ropper.convert(localConcreteMethod, (TranslationAdvice)localObject1, localMethodList);
      m = localCstMethodRef.getParameterWordCount(bool2);
      Object localObject2 = localCstType.getClassType().getDescriptor() + "." + localMethod.getName().getString();
      Object localObject4;
      if ((paramCfOptions.optimize) && (OptimizerOptions.shouldOptimize((String)localObject2)))
      {
        localObject4 = Optimizer.optimize((RopMethod)localObject3, m, bool2, paramCfOptions.localInfo, (TranslationAdvice)localObject1);
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (paramCfOptions.statistics)
        {
          CodeStatistics.updateRopStatistics((RopMethod)localObject3, (RopMethod)localObject4);
          localObject2 = localObject3;
          localObject1 = localObject4;
        }
      }
      for (;;)
      {
        localObject3 = null;
        if (paramCfOptions.localInfo) {
          localObject3 = LocalVariableExtractor.extract((RopMethod)localObject1);
        }
        localObject4 = RopTranslator.translate((RopMethod)localObject1, paramCfOptions.positionInfo, (LocalVariableInfo)localObject3, m, paramDexOptions);
        if ((!paramCfOptions.statistics) || (localObject2 == null)) {
          break label619;
        }
        updateDexStatistics(paramCfOptions, paramDexOptions, (RopMethod)localObject1, (RopMethod)localObject2, (LocalVariableInfo)localObject3, m, localConcreteMethod.getCode().size());
        break label619;
        paramClassDefItem.addVirtualMethod((EncodedMethod)localObject1);
        break;
        return;
        break label593;
        localObject1 = localObject3;
        localObject2 = null;
      }
      for (int k = 1;; k = 0)
      {
        if ((!bool4) && (!bool1)) {
          break label617;
        }
        localObject1 = null;
        break;
        m = i;
        if (k == 0) {
          break label150;
        }
        m = i | 0x10000;
        break label150;
      }
      break label272;
      localObject1 = localObject4;
      break;
    }
  }
  
  public static ClassDefItem translate(DirectClassFile paramDirectClassFile, byte[] paramArrayOfByte, CfOptions paramCfOptions, DexOptions paramDexOptions, DexFile paramDexFile)
  {
    try
    {
      paramArrayOfByte = translate0(paramDirectClassFile, paramArrayOfByte, paramCfOptions, paramDexOptions, paramDexFile);
      return paramArrayOfByte;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      throw ExceptionWithContext.withContext(paramArrayOfByte, "...while processing " + paramDirectClassFile.getFilePath());
    }
  }
  
  private static ClassDefItem translate0(DirectClassFile paramDirectClassFile, byte[] paramArrayOfByte, CfOptions paramCfOptions, DexOptions paramDexOptions, DexFile paramDexFile)
  {
    OptimizerOptions.loadOptimizeLists(paramCfOptions.optimizeListFile, paramCfOptions.dontOptimizeListFile);
    Object localObject = paramDirectClassFile.getThisClass();
    int i = paramDirectClassFile.getAccessFlags();
    MethodIdsSection localMethodIdsSection;
    if (paramCfOptions.positionInfo == 1)
    {
      paramArrayOfByte = null;
      paramArrayOfByte = new ClassDefItem((CstType)localObject, i & 0xFFFFFFDF, paramDirectClassFile.getSuperclass(), paramDirectClassFile.getInterfaces(), paramArrayOfByte);
      localObject = AttributeTranslator.getClassAnnotations(paramDirectClassFile, paramCfOptions);
      if (((Annotations)localObject).size() != 0) {
        paramArrayOfByte.setClassAnnotations((Annotations)localObject, paramDexFile);
      }
      localObject = paramDexFile.getFieldIds();
      localMethodIdsSection = paramDexFile.getMethodIds();
      processFields(paramDirectClassFile, paramArrayOfByte, paramDexFile);
      processMethods(paramDirectClassFile, paramCfOptions, paramDexOptions, paramArrayOfByte, paramDexFile);
      paramDirectClassFile = paramDirectClassFile.getConstantPool();
      int j = paramDirectClassFile.size();
      i = 0;
      label126:
      if (i >= j) {
        return paramArrayOfByte;
      }
      paramCfOptions = paramDirectClassFile.getOrNull(i);
      if (!(paramCfOptions instanceof CstMethodRef)) {
        break label176;
      }
      localMethodIdsSection.intern((CstBaseMethodRef)paramCfOptions);
    }
    for (;;)
    {
      i += 1;
      break label126;
      paramArrayOfByte = paramDirectClassFile.getSourceFile();
      break;
      label176:
      if ((paramCfOptions instanceof CstInterfaceMethodRef)) {
        localMethodIdsSection.intern(((CstInterfaceMethodRef)paramCfOptions).toMethodRef());
      } else if ((paramCfOptions instanceof CstFieldRef)) {
        ((FieldIdsSection)localObject).intern((CstFieldRef)paramCfOptions);
      } else if ((paramCfOptions instanceof CstEnumRef)) {
        ((FieldIdsSection)localObject).intern(((CstEnumRef)paramCfOptions).getFieldRef());
      }
    }
    return paramArrayOfByte;
  }
  
  private static void updateDexStatistics(CfOptions paramCfOptions, DexOptions paramDexOptions, RopMethod paramRopMethod1, RopMethod paramRopMethod2, LocalVariableInfo paramLocalVariableInfo, int paramInt1, int paramInt2)
  {
    paramRopMethod1 = RopTranslator.translate(paramRopMethod1, paramCfOptions.positionInfo, paramLocalVariableInfo, paramInt1, paramDexOptions);
    paramCfOptions = RopTranslator.translate(paramRopMethod2, paramCfOptions.positionInfo, paramLocalVariableInfo, paramInt1, paramDexOptions);
    paramDexOptions = new CfTranslator.1();
    paramRopMethod1.assignIndices(paramDexOptions);
    paramCfOptions.assignIndices(paramDexOptions);
    CodeStatistics.updateDexStatistics(paramCfOptions, paramRopMethod1);
    CodeStatistics.updateOriginalByteCount(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.cf.CfTranslator
 * JD-Core Version:    0.7.0.1
 */