package com.tencent.component.network.module.common.dns;

public class DNSInput
{
  private int jdField_a_of_type_Int;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private int c;
  private int d;
  
  public DNSInput(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = 0;
    this.b = this.jdField_a_of_type_ArrayOfByte.length;
    this.c = -1;
    this.d = -1;
  }
  
  private void c(int paramInt)
  {
    if (paramInt > b()) {
      throw new WireParseException("end of input");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    c(4);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int j = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int k = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int m = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (m + 1);
    m = arrayOfByte[m];
    long l = i & 0xFF;
    return ((j & 0xFF) << 16) + (l << 24) + ((k & 0xFF) << 8) + (m & 0xFF);
  }
  
  public void a()
  {
    this.c = this.jdField_a_of_type_Int;
    this.d = this.b;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_ArrayOfByte.length - this.jdField_a_of_type_Int) {
      throw new IllegalArgumentException("cannot set active region past end of input");
    }
    this.b = (this.jdField_a_of_type_Int + paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramInt2);
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Int += paramInt2;
  }
  
  public byte[] a()
  {
    int i = b();
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, 0, i);
    this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
    this.b = (this.jdField_a_of_type_ArrayOfByte.length - 1);
    return arrayOfByte;
  }
  
  public int b()
  {
    return this.b - this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.c < 0) {
      throw new IllegalStateException("no previous state");
    }
    this.jdField_a_of_type_Int = this.c;
    this.b = this.d;
    this.c = -1;
    this.d = -1;
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_ArrayOfByte.length) {
      throw new IllegalArgumentException("cannot jump past end of input");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.b = this.jdField_a_of_type_ArrayOfByte.length;
  }
  
  public int c()
  {
    c(1);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int d()
  {
    c(2);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int j = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (j + 1);
    return ((i & 0xFF) << 8) + (arrayOfByte[j] & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.DNSInput
 * JD-Core Version:    0.7.0.1
 */