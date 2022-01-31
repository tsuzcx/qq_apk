import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class bgmx
{
  private final bgmz jdField_a_of_type_Bgmz;
  private boolean jdField_a_of_type_Boolean;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean;
  private boolean b;
  
  private bgmx(bgmu parambgmu, bgmz parambgmz)
  {
    this.jdField_a_of_type_Bgmz = parambgmz;
    if (bgmz.a(parambgmz)) {}
    for (parambgmu = null;; parambgmu = new boolean[bgmu.a(parambgmu)])
    {
      this.jdField_a_of_type_ArrayOfBoolean = parambgmu;
      return;
    }
  }
  
  public OutputStream a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= bgmu.a(this.jdField_a_of_type_Bgmu))) {
      throw new IllegalArgumentException("Expected index " + paramInt + " to be greater than 0 and less than the maximum value count of " + bgmu.a(this.jdField_a_of_type_Bgmu));
    }
    synchronized (this.jdField_a_of_type_Bgmu)
    {
      if (bgmz.a(this.jdField_a_of_type_Bgmz) != this) {
        throw new IllegalStateException();
      }
    }
    if (!bgmz.a(this.jdField_a_of_type_Bgmz)) {
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    File localFile = this.jdField_a_of_type_Bgmz.b(paramInt);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new bgmy(this, (OutputStream)localObject2, null);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        bgmu.a(this.jdField_a_of_type_Bgmu).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = bgmu.a();
          return localOutputStream;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bgmu.a(this.jdField_a_of_type_Bgmu, this, false);
      this.jdField_a_of_type_Bgmu.a(bgmz.a(this.jdField_a_of_type_Bgmz));
    }
    for (;;)
    {
      this.b = true;
      return;
      bgmu.a(this.jdField_a_of_type_Bgmu, this, true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(a(paramInt), bgnb.b);
      bgnb.a(localOutputStreamWriter);
    }
    finally
    {
      try
      {
        localOutputStreamWriter.write(paramString);
        bgnb.a(localOutputStreamWriter);
        return;
      }
      finally {}
      paramString = finally;
      localOutputStreamWriter = null;
    }
    throw paramString;
  }
  
  public void b()
  {
    bgmu.a(this.jdField_a_of_type_Bgmu, this, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmx
 * JD-Core Version:    0.7.0.1
 */