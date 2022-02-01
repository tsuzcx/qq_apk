package com.google.protobuf;

import java.util.Collections;
import java.util.List;

public final class Descriptors$FieldDescriptor
  extends Descriptors.GenericDescriptor
  implements FieldSet.FieldDescriptorLite<FieldDescriptor>, Comparable<FieldDescriptor>
{
  private static final WireFormat.FieldType[] a = ;
  private final int b;
  private DescriptorProtos.FieldDescriptorProto c;
  private final String d;
  private final String e;
  private final Descriptors.FileDescriptor f;
  private final Descriptors.Descriptor g;
  private Descriptors.FieldDescriptor.Type h;
  private Descriptors.Descriptor i;
  private Descriptors.Descriptor j;
  private Descriptors.OneofDescriptor k;
  private Descriptors.EnumDescriptor l;
  private Object m;
  
  static
  {
    if (Descriptors.FieldDescriptor.Type.values().length == DescriptorProtos.FieldDescriptorProto.Type.values().length) {
      return;
    }
    throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
  }
  
  private Descriptors$FieldDescriptor(DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto, Descriptors.FileDescriptor paramFileDescriptor, Descriptors.Descriptor paramDescriptor, int paramInt, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramFieldDescriptorProto;
    this.d = Descriptors.a(paramFileDescriptor, paramDescriptor, paramFieldDescriptorProto.getName());
    this.f = paramFileDescriptor;
    if (paramFieldDescriptorProto.hasJsonName()) {
      this.e = paramFieldDescriptorProto.getJsonName();
    } else {
      this.e = a(paramFieldDescriptorProto.getName());
    }
    if (paramFieldDescriptorProto.hasType()) {
      this.h = Descriptors.FieldDescriptor.Type.valueOf(paramFieldDescriptorProto.getType());
    }
    if (f() > 0)
    {
      if (paramBoolean)
      {
        if (paramFieldDescriptorProto.hasExtendee())
        {
          this.i = null;
          if (paramDescriptor != null) {
            this.g = paramDescriptor;
          } else {
            this.g = null;
          }
          if (!paramFieldDescriptorProto.hasOneofIndex()) {
            this.k = null;
          } else {
            throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", null);
          }
        }
        else
        {
          throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", null);
        }
      }
      else
      {
        if (paramFieldDescriptorProto.hasExtendee()) {
          break label288;
        }
        this.i = paramDescriptor;
        if (paramFieldDescriptorProto.hasOneofIndex())
        {
          if ((paramFieldDescriptorProto.getOneofIndex() >= 0) && (paramFieldDescriptorProto.getOneofIndex() < paramDescriptor.a().getOneofDeclCount()))
          {
            this.k = ((Descriptors.OneofDescriptor)paramDescriptor.g().get(paramFieldDescriptorProto.getOneofIndex()));
            Descriptors.OneofDescriptor.b(this.k);
          }
          else
          {
            paramFieldDescriptorProto = new StringBuilder();
            paramFieldDescriptorProto.append("FieldDescriptorProto.oneof_index is out of range for type ");
            paramFieldDescriptorProto.append(paramDescriptor.b());
            throw new Descriptors.DescriptorValidationException(this, paramFieldDescriptorProto.toString(), null);
          }
        }
        else {
          this.k = null;
        }
        this.g = null;
      }
      Descriptors.FileDescriptor.a(paramFileDescriptor).c(this);
      return;
      label288:
      throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", null);
    }
    throw new Descriptors.DescriptorValidationException(this, "Field numbers must be positive integers.", null);
  }
  
  private void A()
  {
    Object localObject;
    if (this.c.hasExtendee())
    {
      localObject = Descriptors.FileDescriptor.a(this.f).a(this.c.getExtendee(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
      if ((localObject instanceof Descriptors.Descriptor))
      {
        this.i = ((Descriptors.Descriptor)localObject);
        if (!v().a(f()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append('"');
          ((StringBuilder)localObject).append(v().c());
          ((StringBuilder)localObject).append("\" does not declare ");
          ((StringBuilder)localObject).append(f());
          ((StringBuilder)localObject).append(" as an extension number.");
          throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append('"');
        ((StringBuilder)localObject).append(this.c.getExtendee());
        ((StringBuilder)localObject).append("\" is not a message type.");
        throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
      }
    }
    if (this.c.hasTypeName())
    {
      localObject = Descriptors.FileDescriptor.a(this.f).a(this.c.getTypeName(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
      if (!this.c.hasType()) {
        if ((localObject instanceof Descriptors.Descriptor))
        {
          this.h = Descriptors.FieldDescriptor.Type.MESSAGE;
        }
        else if ((localObject instanceof Descriptors.EnumDescriptor))
        {
          this.h = Descriptors.FieldDescriptor.Type.ENUM;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append('"');
          ((StringBuilder)localObject).append(this.c.getTypeName());
          ((StringBuilder)localObject).append("\" is not a type.");
          throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
        }
      }
      if (g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
      {
        if ((localObject instanceof Descriptors.Descriptor))
        {
          this.j = ((Descriptors.Descriptor)localObject);
          if (this.c.hasDefaultValue()) {
            throw new Descriptors.DescriptorValidationException(this, "Messages can't have default values.", null);
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append('"');
          ((StringBuilder)localObject).append(this.c.getTypeName());
          ((StringBuilder)localObject).append("\" is not a message type.");
          throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
        }
      }
      else if (g() == Descriptors.FieldDescriptor.JavaType.ENUM)
      {
        if ((localObject instanceof Descriptors.EnumDescriptor))
        {
          this.l = ((Descriptors.EnumDescriptor)localObject);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append('"');
          ((StringBuilder)localObject).append(this.c.getTypeName());
          ((StringBuilder)localObject).append("\" is not an enum type.");
          throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
        }
      }
      else {
        throw new Descriptors.DescriptorValidationException(this, "Field with primitive type has type_name.", null);
      }
    }
    else
    {
      if ((g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) || (g() == Descriptors.FieldDescriptor.JavaType.ENUM)) {
        break label1361;
      }
    }
    if ((this.c.getOptions().getPacked()) && (!r())) {
      throw new Descriptors.DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", null);
    }
    int n;
    if (this.c.hasDefaultValue())
    {
      if (!p()) {
        try
        {
          n = Descriptors.1.a[i().ordinal()];
          switch (n)
          {
          default: 
            break;
          case 17: 
          case 18: 
            throw new Descriptors.DescriptorValidationException(this, "Message type had default value.", null);
          case 16: 
            this.m = this.l.a(this.c.getDefaultValue());
            if (this.m != null) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unknown enum default value: \"");
            ((StringBuilder)localObject).append(this.c.getDefaultValue());
            ((StringBuilder)localObject).append('"');
            throw new Descriptors.DescriptorValidationException(this, ((StringBuilder)localObject).toString(), null);
          case 15: 
            try
            {
              this.m = TextFormat.a(this.c.getDefaultValue());
            }
            catch (TextFormat.InvalidEscapeSequenceException localInvalidEscapeSequenceException)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("Couldn't parse default value: ");
              localStringBuilder.append(localInvalidEscapeSequenceException.getMessage());
              throw new Descriptors.DescriptorValidationException(this, localStringBuilder.toString(), localInvalidEscapeSequenceException, null);
            }
          case 14: 
            this.m = this.c.getDefaultValue();
            break;
          case 13: 
            this.m = Boolean.valueOf(this.c.getDefaultValue());
            break;
          case 12: 
            if (this.c.getDefaultValue().equals("inf")) {
              this.m = Double.valueOf((1.0D / 0.0D));
            } else if (this.c.getDefaultValue().equals("-inf")) {
              this.m = Double.valueOf((-1.0D / 0.0D));
            } else if (this.c.getDefaultValue().equals("nan")) {
              this.m = Double.valueOf((0.0D / 0.0D));
            } else {
              this.m = Double.valueOf(this.c.getDefaultValue());
            }
            break;
          case 11: 
            if (this.c.getDefaultValue().equals("inf")) {
              this.m = Float.valueOf((1.0F / 1.0F));
            } else if (this.c.getDefaultValue().equals("-inf")) {
              this.m = Float.valueOf((1.0F / -1.0F));
            } else if (this.c.getDefaultValue().equals("nan")) {
              this.m = Float.valueOf((0.0F / 0.0F));
            } else {
              this.m = Float.valueOf(this.c.getDefaultValue());
            }
            break;
          case 9: 
          case 10: 
            this.m = Long.valueOf(TextFormat.e(this.c.getDefaultValue()));
            break;
          case 6: 
          case 7: 
          case 8: 
            this.m = Long.valueOf(TextFormat.d(this.c.getDefaultValue()));
            break;
          case 4: 
          case 5: 
            this.m = Integer.valueOf(TextFormat.c(this.c.getDefaultValue()));
            break;
          case 1: 
          case 2: 
          case 3: 
            this.m = Integer.valueOf(TextFormat.b(this.c.getDefaultValue()));
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Could not parse default value: \"");
          localStringBuilder.append(this.c.getDefaultValue());
          localStringBuilder.append('"');
          throw new Descriptors.DescriptorValidationException(this, localStringBuilder.toString(), localNumberFormatException, null);
        }
      } else {
        throw new Descriptors.DescriptorValidationException(this, "Repeated fields cannot have default values.", null);
      }
    }
    else if (p())
    {
      this.m = Collections.emptyList();
    }
    else
    {
      n = Descriptors.1.b[g().ordinal()];
      if (n != 1)
      {
        if (n != 2) {
          this.m = Descriptors.FieldDescriptor.JavaType.access$2300(g());
        } else {
          this.m = null;
        }
      }
      else {
        this.m = this.l.e().get(0);
      }
    }
    if (!u()) {
      Descriptors.FileDescriptor.a(this.f).a(this);
    }
    Descriptors.Descriptor localDescriptor = this.i;
    if ((localDescriptor != null) && (localDescriptor.e().getMessageSetWireFormat()))
    {
      if (u())
      {
        if ((o()) && (i() == Descriptors.FieldDescriptor.Type.MESSAGE)) {
          return;
        }
        throw new Descriptors.DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", null);
      }
      throw new Descriptors.DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.", null);
    }
    return;
    label1361:
    throw new Descriptors.DescriptorValidationException(this, "Field with message or enum type missing type_name.", null);
  }
  
  private static String a(String paramString)
  {
    int i2 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i2);
    int i1 = 0;
    int n = 0;
    while (i1 < i2)
    {
      char c2 = paramString.charAt(i1);
      if (c2 == '_')
      {
        n = 1;
      }
      else if (n != 0)
      {
        char c1 = c2;
        if ('a' <= c2)
        {
          c1 = c2;
          if (c2 <= 'z') {
            c1 = (char)(c2 - 'a' + 65);
          }
        }
        localStringBuilder.append(c1);
        n = 0;
      }
      else
      {
        localStringBuilder.append(c2);
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(FieldDescriptor paramFieldDescriptor)
  {
    if (paramFieldDescriptor.i == this.i) {
      return f() - paramFieldDescriptor.f();
    }
    throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
  }
  
  public MessageLite.Builder a(MessageLite.Builder paramBuilder, MessageLite paramMessageLite)
  {
    return ((Message.Builder)paramBuilder).mergeFrom((Message)paramMessageLite);
  }
  
  public String b()
  {
    return this.c.getName();
  }
  
  public String c()
  {
    return this.d;
  }
  
  public Descriptors.FileDescriptor d()
  {
    return this.f;
  }
  
  public DescriptorProtos.FieldDescriptorProto e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.c.getNumber();
  }
  
  public Descriptors.FieldDescriptor.JavaType g()
  {
    return this.h.getJavaType();
  }
  
  public WireFormat.JavaType h()
  {
    return j().getJavaType();
  }
  
  public Descriptors.FieldDescriptor.Type i()
  {
    return this.h;
  }
  
  public WireFormat.FieldType j()
  {
    return a[this.h.ordinal()];
  }
  
  public boolean k()
  {
    if (this.h != Descriptors.FieldDescriptor.Type.STRING) {
      return false;
    }
    if (v().e().getMapEntry()) {
      return true;
    }
    if (d().j() == Descriptors.FileDescriptor.Syntax.PROTO3) {
      return true;
    }
    return d().f().getJavaStringCheckUtf8();
  }
  
  public boolean m()
  {
    return (i() == Descriptors.FieldDescriptor.Type.MESSAGE) && (p()) && (y().e().getMapEntry());
  }
  
  public boolean n()
  {
    return this.c.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED;
  }
  
  public boolean o()
  {
    return this.c.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
  }
  
  public boolean p()
  {
    return this.c.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
  }
  
  public boolean q()
  {
    boolean bool2 = r();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (d().j() == Descriptors.FileDescriptor.Syntax.PROTO2) {
      return t().getPacked();
    }
    if ((!t().hasPacked()) || (t().getPacked())) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean r()
  {
    return (p()) && (j().isPackable());
  }
  
  public Object s()
  {
    if (g() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      return this.m;
    }
    throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
  }
  
  public DescriptorProtos.FieldOptions t()
  {
    return this.c.getOptions();
  }
  
  public String toString()
  {
    return c();
  }
  
  public boolean u()
  {
    return this.c.hasExtendee();
  }
  
  public Descriptors.Descriptor v()
  {
    return this.i;
  }
  
  public Descriptors.OneofDescriptor w()
  {
    return this.k;
  }
  
  public Descriptors.Descriptor x()
  {
    if (u()) {
      return this.g;
    }
    throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", new Object[] { this.d }));
  }
  
  public Descriptors.Descriptor y()
  {
    if (g() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      return this.j;
    }
    throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", new Object[] { this.d }));
  }
  
  public Descriptors.EnumDescriptor z()
  {
    if (g() == Descriptors.FieldDescriptor.JavaType.ENUM) {
      return this.l;
    }
    throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", new Object[] { this.d }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.FieldDescriptor
 * JD-Core Version:    0.7.0.1
 */