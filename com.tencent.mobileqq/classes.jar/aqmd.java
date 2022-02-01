import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public abstract class aqmd
{
  public byte a;
  private final int jdField_a_of_type_Int = aptj.a();
  public long a;
  protected ArrayList a;
  public short a;
  private boolean jdField_a_of_type_Boolean;
  public long b = -1L;
  public long c = -1L;
  
  public aqmd(short paramShort, byte paramByte)
  {
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Short = paramShort;
    this.jdField_a_of_type_Byte = paramByte;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public abstract void a();
  
  public abstract void a(DataInputStream paramDataInputStream);
  
  public abstract void a(DataOutputStream paramDataOutputStream);
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {}
    label85:
    for (;;)
    {
      return;
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        aqmj localaqmj = (aqmj)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localaqmj.d == null) || (!localaqmj.d.contains(paramString))) {}
      }
      for (;;)
      {
        if (i == -1) {
          break label85;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        return;
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return (this.c > 0L) && (this.c <= System.currentTimeMillis());
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public final boolean b()
  {
    return this.b > System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmd
 * JD-Core Version:    0.7.0.1
 */