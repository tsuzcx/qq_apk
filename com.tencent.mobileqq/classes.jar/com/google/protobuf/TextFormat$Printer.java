package com.google.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class TextFormat$Printer
{
  static final Printer a = new Printer(true);
  static final Printer b = new Printer(false);
  private final boolean c;
  
  private TextFormat$Printer(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  private void a(int paramInt1, int paramInt2, List<?> paramList, TextFormat.TextGenerator paramTextGenerator)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      paramTextGenerator.a(String.valueOf(paramInt1));
      paramTextGenerator.a(": ");
      TextFormat.a(paramInt2, localObject, paramTextGenerator);
      paramTextGenerator.c();
    }
  }
  
  private void a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, TextFormat.TextGenerator paramTextGenerator)
  {
    if (paramFieldDescriptor.p())
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        b(paramFieldDescriptor, paramObject.next(), paramTextGenerator);
      }
    }
    b(paramFieldDescriptor, paramObject, paramTextGenerator);
  }
  
  private void a(MessageOrBuilder paramMessageOrBuilder, TextFormat.TextGenerator paramTextGenerator)
  {
    Iterator localIterator = paramMessageOrBuilder.getAllFields().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((Descriptors.FieldDescriptor)localEntry.getKey(), localEntry.getValue(), paramTextGenerator);
    }
    a(paramMessageOrBuilder.getUnknownFields(), paramTextGenerator);
  }
  
  private void a(UnknownFieldSet paramUnknownFieldSet, TextFormat.TextGenerator paramTextGenerator)
  {
    paramUnknownFieldSet = paramUnknownFieldSet.d().entrySet().iterator();
    while (paramUnknownFieldSet.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramUnknownFieldSet.next();
      int i = ((Integer)localEntry.getKey()).intValue();
      Object localObject = (UnknownFieldSet.Field)localEntry.getValue();
      a(i, 0, ((UnknownFieldSet.Field)localObject).b(), paramTextGenerator);
      a(i, 5, ((UnknownFieldSet.Field)localObject).c(), paramTextGenerator);
      a(i, 1, ((UnknownFieldSet.Field)localObject).d(), paramTextGenerator);
      a(i, 2, ((UnknownFieldSet.Field)localObject).e(), paramTextGenerator);
      localObject = ((UnknownFieldSet.Field)localObject).f().iterator();
      while (((Iterator)localObject).hasNext())
      {
        UnknownFieldSet localUnknownFieldSet = (UnknownFieldSet)((Iterator)localObject).next();
        paramTextGenerator.a(((Integer)localEntry.getKey()).toString());
        paramTextGenerator.a(" {");
        paramTextGenerator.c();
        paramTextGenerator.a();
        a(localUnknownFieldSet, paramTextGenerator);
        paramTextGenerator.b();
        paramTextGenerator.a("}");
        paramTextGenerator.c();
      }
    }
  }
  
  private void b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, TextFormat.TextGenerator paramTextGenerator)
  {
    if (paramFieldDescriptor.u())
    {
      paramTextGenerator.a("[");
      if ((paramFieldDescriptor.v().e().getMessageSetWireFormat()) && (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.MESSAGE) && (paramFieldDescriptor.o()) && (paramFieldDescriptor.x() == paramFieldDescriptor.y())) {
        paramTextGenerator.a(paramFieldDescriptor.y().c());
      } else {
        paramTextGenerator.a(paramFieldDescriptor.c());
      }
      paramTextGenerator.a("]");
    }
    else if (paramFieldDescriptor.i() == Descriptors.FieldDescriptor.Type.GROUP)
    {
      paramTextGenerator.a(paramFieldDescriptor.y().b());
    }
    else
    {
      paramTextGenerator.a(paramFieldDescriptor.b());
    }
    if (paramFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
    {
      paramTextGenerator.a(" {");
      paramTextGenerator.c();
      paramTextGenerator.a();
    }
    else
    {
      paramTextGenerator.a(": ");
    }
    c(paramFieldDescriptor, paramObject, paramTextGenerator);
    if (paramFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
    {
      paramTextGenerator.b();
      paramTextGenerator.a("}");
    }
    paramTextGenerator.c();
  }
  
  private void c(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, TextFormat.TextGenerator paramTextGenerator)
  {
    switch (TextFormat.1.a[paramFieldDescriptor.i().ordinal()])
    {
    default: 
      return;
    case 17: 
    case 18: 
      a((Message)paramObject, paramTextGenerator);
      return;
    case 16: 
      paramTextGenerator.a(((Descriptors.EnumValueDescriptor)paramObject).b());
      return;
    case 15: 
      paramTextGenerator.a("\"");
      if ((paramObject instanceof ByteString)) {
        paramTextGenerator.a(TextFormat.a((ByteString)paramObject));
      } else {
        paramTextGenerator.a(TextFormat.a((byte[])paramObject));
      }
      paramTextGenerator.a("\"");
      return;
    case 14: 
      paramTextGenerator.a("\"");
      if (this.c) {
        paramFieldDescriptor = TextFormatEscaper.a((String)paramObject);
      } else {
        paramFieldDescriptor = TextFormat.a((String)paramObject).replace("\n", "\\n");
      }
      paramTextGenerator.a(paramFieldDescriptor);
      paramTextGenerator.a("\"");
      return;
    case 12: 
    case 13: 
      paramTextGenerator.a(TextFormat.a(((Long)paramObject).longValue()));
      return;
    case 10: 
    case 11: 
      paramTextGenerator.a(TextFormat.a(((Integer)paramObject).intValue()));
      return;
    case 9: 
      paramTextGenerator.a(((Double)paramObject).toString());
      return;
    case 8: 
      paramTextGenerator.a(((Float)paramObject).toString());
      return;
    case 7: 
      paramTextGenerator.a(((Boolean)paramObject).toString());
      return;
    case 4: 
    case 5: 
    case 6: 
      paramTextGenerator.a(((Long)paramObject).toString());
      return;
    }
    paramTextGenerator.a(((Integer)paramObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormat.Printer
 * JD-Core Version:    0.7.0.1
 */