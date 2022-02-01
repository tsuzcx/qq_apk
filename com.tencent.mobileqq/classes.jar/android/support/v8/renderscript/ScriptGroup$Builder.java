package android.support.v8.renderscript;

import java.util.ArrayList;

public final class ScriptGroup$Builder
{
  private int mKernelCount;
  private ArrayList<ScriptGroup.ConnectLine> mLines = new ArrayList();
  private ArrayList<ScriptGroup.Node> mNodes = new ArrayList();
  private RenderScript mRS;
  private ScriptGroupThunker.Builder mT;
  
  public ScriptGroup$Builder(RenderScript paramRenderScript)
  {
    if (RenderScript.isNative) {
      this.mT = new ScriptGroupThunker.Builder(paramRenderScript);
    }
    this.mRS = paramRenderScript;
  }
  
  private ScriptGroup.Node findNode(Script.KernelID paramKernelID)
  {
    int i = 0;
    while (i < this.mNodes.size())
    {
      ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
      int j = 0;
      while (j < localNode.mKernels.size())
      {
        if (paramKernelID == localNode.mKernels.get(j)) {
          return localNode;
        }
        j += 1;
      }
      i += 1;
    }
    return null;
  }
  
  private ScriptGroup.Node findNode(Script paramScript)
  {
    int i = 0;
    while (i < this.mNodes.size())
    {
      if (paramScript == ((ScriptGroup.Node)this.mNodes.get(i)).mScript) {
        return (ScriptGroup.Node)this.mNodes.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private void mergeDAGs(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.mNodes.size())
    {
      if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber == paramInt2) {
        ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = paramInt1;
      }
      i += 1;
    }
  }
  
  private void validateCycle(ScriptGroup.Node paramNode1, ScriptGroup.Node paramNode2)
  {
    int i = 0;
    while (i < paramNode1.mOutputs.size())
    {
      Object localObject = (ScriptGroup.ConnectLine)paramNode1.mOutputs.get(i);
      if (((ScriptGroup.ConnectLine)localObject).mToK != null)
      {
        ScriptGroup.Node localNode = findNode(((ScriptGroup.ConnectLine)localObject).mToK.mScript);
        if (!localNode.equals(paramNode2)) {
          validateCycle(localNode, paramNode2);
        } else {
          throw new RSInvalidStateException("Loops in group not allowed.");
        }
      }
      if (((ScriptGroup.ConnectLine)localObject).mToF != null)
      {
        localObject = findNode(((ScriptGroup.ConnectLine)localObject).mToF.mScript);
        if (!localObject.equals(paramNode2)) {
          validateCycle((ScriptGroup.Node)localObject, paramNode2);
        } else {
          throw new RSInvalidStateException("Loops in group not allowed.");
        }
      }
      i += 1;
    }
  }
  
  private void validateDAG()
  {
    int j = 0;
    int i = 0;
    while (i < this.mNodes.size())
    {
      ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
      if (localNode.mInputs.size() == 0)
      {
        if ((localNode.mOutputs.size() == 0) && (this.mNodes.size() > 1)) {
          throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
        }
        validateDAGRecurse(localNode, i + 1);
      }
      i += 1;
    }
    int k = ((ScriptGroup.Node)this.mNodes.get(0)).dagNumber;
    i = j;
    while (i < this.mNodes.size()) {
      if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber == k) {
        i += 1;
      } else {
        throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
      }
    }
  }
  
  private void validateDAGRecurse(ScriptGroup.Node paramNode, int paramInt)
  {
    if ((paramNode.dagNumber != 0) && (paramNode.dagNumber != paramInt))
    {
      mergeDAGs(paramNode.dagNumber, paramInt);
      return;
    }
    paramNode.dagNumber = paramInt;
    int i = 0;
    while (i < paramNode.mOutputs.size())
    {
      ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)paramNode.mOutputs.get(i);
      if (localConnectLine.mToK != null) {
        validateDAGRecurse(findNode(localConnectLine.mToK.mScript), paramInt);
      }
      if (localConnectLine.mToF != null) {
        validateDAGRecurse(findNode(localConnectLine.mToF.mScript), paramInt);
      }
      i += 1;
    }
  }
  
  public Builder addConnection(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
  {
    Object localObject = this.mT;
    if (localObject != null)
    {
      ((ScriptGroupThunker.Builder)localObject).addConnection(paramType, paramKernelID, paramFieldID);
      return this;
    }
    localObject = findNode(paramKernelID);
    if (localObject != null)
    {
      ScriptGroup.Node localNode = findNode(paramFieldID.mScript);
      if (localNode != null)
      {
        ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID);
        this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID));
        ((ScriptGroup.Node)localObject).mOutputs.add(localConnectLine);
        localNode.mInputs.add(localConnectLine);
        validateCycle((ScriptGroup.Node)localObject, (ScriptGroup.Node)localObject);
        return this;
      }
      throw new RSInvalidStateException("To script not found.");
    }
    throw new RSInvalidStateException("From script not found.");
  }
  
  public Builder addConnection(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
  {
    Object localObject = this.mT;
    if (localObject != null)
    {
      ((ScriptGroupThunker.Builder)localObject).addConnection(paramType, paramKernelID1, paramKernelID2);
      return this;
    }
    localObject = findNode(paramKernelID1);
    if (localObject != null)
    {
      ScriptGroup.Node localNode = findNode(paramKernelID2);
      if (localNode != null)
      {
        ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2);
        this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2));
        ((ScriptGroup.Node)localObject).mOutputs.add(localConnectLine);
        localNode.mInputs.add(localConnectLine);
        validateCycle((ScriptGroup.Node)localObject, (ScriptGroup.Node)localObject);
        return this;
      }
      throw new RSInvalidStateException("To script not found.");
    }
    throw new RSInvalidStateException("From script not found.");
  }
  
  public Builder addKernel(Script.KernelID paramKernelID)
  {
    Object localObject = this.mT;
    if (localObject != null)
    {
      ((ScriptGroupThunker.Builder)localObject).addKernel(paramKernelID);
      return this;
    }
    if (this.mLines.size() == 0)
    {
      if (findNode(paramKernelID) != null) {
        return this;
      }
      this.mKernelCount += 1;
      ScriptGroup.Node localNode = findNode(paramKernelID.mScript);
      localObject = localNode;
      if (localNode == null)
      {
        localObject = new ScriptGroup.Node(paramKernelID.mScript);
        this.mNodes.add(localObject);
      }
      ((ScriptGroup.Node)localObject).mKernels.add(paramKernelID);
      return this;
    }
    throw new RSInvalidStateException("Kernels may not be added once connections exist.");
  }
  
  public ScriptGroup create()
  {
    Object localObject1 = this.mT;
    if (localObject1 != null) {
      return ((ScriptGroupThunker.Builder)localObject1).create();
    }
    if (this.mNodes.size() != 0)
    {
      int i2 = 0;
      int i = 0;
      while (i < this.mNodes.size())
      {
        ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = 0;
        i += 1;
      }
      validateDAG();
      localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = new int[this.mKernelCount];
      int j = 0;
      i = 0;
      Object localObject3;
      Object localObject4;
      while (j < this.mNodes.size())
      {
        localObject3 = (ScriptGroup.Node)this.mNodes.get(j);
        int k = 0;
        while (k < ((ScriptGroup.Node)localObject3).mKernels.size())
        {
          localObject4 = (Script.KernelID)((ScriptGroup.Node)localObject3).mKernels.get(k);
          localObject2[i] = ((Script.KernelID)localObject4).getID(this.mRS);
          int n = 0;
          int m = 0;
          while (n < ((ScriptGroup.Node)localObject3).mInputs.size())
          {
            if (((ScriptGroup.ConnectLine)((ScriptGroup.Node)localObject3).mInputs.get(n)).mToK == localObject4) {
              m = 1;
            }
            n += 1;
          }
          n = 0;
          int i1 = 0;
          while (n < ((ScriptGroup.Node)localObject3).mOutputs.size())
          {
            if (((ScriptGroup.ConnectLine)((ScriptGroup.Node)localObject3).mOutputs.get(n)).mFrom == localObject4) {
              i1 = 1;
            }
            n += 1;
          }
          if (m == 0) {
            ((ArrayList)localObject1).add(new ScriptGroup.IO((Script.KernelID)localObject4));
          }
          if (i1 == 0) {
            localArrayList.add(new ScriptGroup.IO((Script.KernelID)localObject4));
          }
          k += 1;
          i += 1;
        }
        j += 1;
      }
      if (i == this.mKernelCount)
      {
        localObject3 = new int[this.mLines.size()];
        localObject4 = new int[this.mLines.size()];
        int[] arrayOfInt1 = new int[this.mLines.size()];
        int[] arrayOfInt2 = new int[this.mLines.size()];
        i = 0;
        while (i < this.mLines.size())
        {
          ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)this.mLines.get(i);
          localObject3[i] = localConnectLine.mFrom.getID(this.mRS);
          if (localConnectLine.mToK != null) {
            localObject4[i] = localConnectLine.mToK.getID(this.mRS);
          }
          if (localConnectLine.mToF != null) {
            arrayOfInt1[i] = localConnectLine.mToF.getID(this.mRS);
          }
          arrayOfInt2[i] = localConnectLine.mAllocationType.getID(this.mRS);
          i += 1;
        }
        i = this.mRS.nScriptGroupCreate((int[])localObject2, (int[])localObject3, (int[])localObject4, arrayOfInt1, arrayOfInt2);
        if (i != 0)
        {
          localObject2 = new ScriptGroup(i, this.mRS);
          ((ScriptGroup)localObject2).mOutputs = new ScriptGroup.IO[localArrayList.size()];
          i = 0;
          while (i < localArrayList.size())
          {
            ((ScriptGroup)localObject2).mOutputs[i] = ((ScriptGroup.IO)localArrayList.get(i));
            i += 1;
          }
          ((ScriptGroup)localObject2).mInputs = new ScriptGroup.IO[((ArrayList)localObject1).size()];
          i = i2;
          while (i < ((ArrayList)localObject1).size())
          {
            ((ScriptGroup)localObject2).mInputs[i] = ((ScriptGroup.IO)((ArrayList)localObject1).get(i));
            i += 1;
          }
          return localObject2;
        }
        throw new RSRuntimeException("Object creation error, should not happen.");
      }
      throw new RSRuntimeException("Count mismatch, should not happen.");
    }
    localObject1 = new RSInvalidStateException("Empty script groups are not allowed");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup.Builder
 * JD-Core Version:    0.7.0.1
 */