package com.google.protobuf.nano;

public final class FileOptions
  extends ExtendableMessageNano<FileOptions>
{
  public String a;
  public String b;
  public boolean c;
  public boolean d;
  public boolean e;
  public int f;
  public String g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public UninterpretedOption[] u;
  
  public FileOptions()
  {
    a();
  }
  
  public FileOptions a()
  {
    this.a = "";
    this.b = "";
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = 1;
    this.g = "";
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = false;
    this.l = false;
    this.m = false;
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = "";
    this.s = "";
    this.t = "";
    this.u = UninterpretedOption.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public FileOptions a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 7994: 
        int i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 7994);
        UninterpretedOption[] arrayOfUninterpretedOption = this.u;
        if (arrayOfUninterpretedOption == null) {
          i1 = 0;
        } else {
          i1 = arrayOfUninterpretedOption.length;
        }
        arrayOfUninterpretedOption = new UninterpretedOption[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.u, 0, arrayOfUninterpretedOption, 0, i1);
          i2 = i1;
        }
        while (i2 < arrayOfUninterpretedOption.length - 1)
        {
          arrayOfUninterpretedOption[i2] = new UninterpretedOption();
          paramCodedInputByteBufferNano.readMessage(arrayOfUninterpretedOption[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        arrayOfUninterpretedOption[i2] = new UninterpretedOption();
        paramCodedInputByteBufferNano.readMessage(arrayOfUninterpretedOption[i2]);
        this.u = arrayOfUninterpretedOption;
        break;
      case 362: 
        this.t = paramCodedInputByteBufferNano.readString();
        break;
      case 354: 
        this.s = paramCodedInputByteBufferNano.readString();
        break;
      case 336: 
        this.k = paramCodedInputByteBufferNano.readBool();
        break;
      case 330: 
        this.r = paramCodedInputByteBufferNano.readString();
        break;
      case 322: 
        this.q = paramCodedInputByteBufferNano.readString();
        break;
      case 314: 
        this.p = paramCodedInputByteBufferNano.readString();
        break;
      case 298: 
        this.o = paramCodedInputByteBufferNano.readString();
        break;
      case 290: 
        this.n = paramCodedInputByteBufferNano.readString();
        break;
      case 248: 
        this.m = paramCodedInputByteBufferNano.readBool();
        break;
      case 216: 
        this.e = paramCodedInputByteBufferNano.readBool();
        break;
      case 184: 
        this.l = paramCodedInputByteBufferNano.readBool();
        break;
      case 160: 
        this.d = paramCodedInputByteBufferNano.readBool();
        break;
      case 144: 
        this.j = paramCodedInputByteBufferNano.readBool();
        break;
      case 136: 
        this.i = paramCodedInputByteBufferNano.readBool();
        break;
      case 128: 
        this.h = paramCodedInputByteBufferNano.readBool();
        break;
      case 90: 
        this.g = paramCodedInputByteBufferNano.readString();
        break;
      case 80: 
        this.c = paramCodedInputByteBufferNano.readBool();
        break;
      case 72: 
        i1 = paramCodedInputByteBufferNano.readInt32();
        if ((i1 == 1) || (i1 == 2) || (i1 == 3)) {
          this.f = i1;
        }
        break;
      case 66: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i1 = super.computeSerializedSize();
    int i2 = i1;
    if (!this.a.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    i1 = i2;
    if (!this.b.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(8, this.b);
    }
    int i3 = this.f;
    i2 = i1;
    if (i3 != 1) {
      i2 = i1 + CodedOutputByteBufferNano.computeInt32Size(9, i3);
    }
    boolean bool = this.c;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(10, bool);
    }
    i2 = i1;
    if (!this.g.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(11, this.g);
    }
    bool = this.h;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(16, bool);
    }
    bool = this.i;
    i2 = i1;
    if (bool) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(17, bool);
    }
    bool = this.j;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(18, bool);
    }
    bool = this.d;
    i2 = i1;
    if (bool) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(20, bool);
    }
    bool = this.l;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(23, bool);
    }
    bool = this.e;
    i2 = i1;
    if (bool) {
      i2 = i1 + CodedOutputByteBufferNano.computeBoolSize(27, bool);
    }
    bool = this.m;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(31, bool);
    }
    i2 = i1;
    if (!this.n.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(36, this.n);
    }
    i1 = i2;
    if (!this.o.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(37, this.o);
    }
    i2 = i1;
    if (!this.p.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(39, this.p);
    }
    i1 = i2;
    if (!this.q.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(40, this.q);
    }
    i2 = i1;
    if (!this.r.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(41, this.r);
    }
    bool = this.k;
    i1 = i2;
    if (bool) {
      i1 = i2 + CodedOutputByteBufferNano.computeBoolSize(42, bool);
    }
    i2 = i1;
    if (!this.s.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(44, this.s);
    }
    i1 = i2;
    if (!this.t.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(45, this.t);
    }
    Object localObject = this.u;
    i3 = i1;
    if (localObject != null)
    {
      i3 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.u;
          i3 = i1;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(999, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
      }
    }
    return i3;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.b);
    }
    int i1 = this.f;
    if (i1 != 1) {
      paramCodedOutputByteBufferNano.writeInt32(9, i1);
    }
    boolean bool = this.c;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(10, bool);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(11, this.g);
    }
    bool = this.h;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(16, bool);
    }
    bool = this.i;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(17, bool);
    }
    bool = this.j;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(18, bool);
    }
    bool = this.d;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(20, bool);
    }
    bool = this.l;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(23, bool);
    }
    bool = this.e;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(27, bool);
    }
    bool = this.m;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(31, bool);
    }
    if (!this.n.equals("")) {
      paramCodedOutputByteBufferNano.writeString(36, this.n);
    }
    if (!this.o.equals("")) {
      paramCodedOutputByteBufferNano.writeString(37, this.o);
    }
    if (!this.p.equals("")) {
      paramCodedOutputByteBufferNano.writeString(39, this.p);
    }
    if (!this.q.equals("")) {
      paramCodedOutputByteBufferNano.writeString(40, this.q);
    }
    if (!this.r.equals("")) {
      paramCodedOutputByteBufferNano.writeString(41, this.r);
    }
    bool = this.k;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(42, bool);
    }
    if (!this.s.equals("")) {
      paramCodedOutputByteBufferNano.writeString(44, this.s);
    }
    if (!this.t.equals("")) {
      paramCodedOutputByteBufferNano.writeString(45, this.t);
    }
    Object localObject = this.u;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.u;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(999, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FileOptions
 * JD-Core Version:    0.7.0.1
 */