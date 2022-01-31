import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class bgiq
{
  private final bgis jdField_a_of_type_Bgis;
  private boolean jdField_a_of_type_Boolean;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean;
  private boolean b;
  
  private bgiq(bgin parambgin, bgis parambgis)
  {
    this.jdField_a_of_type_Bgis = parambgis;
    if (bgis.a(parambgis)) {}
    for (parambgin = null;; parambgin = new boolean[bgin.a(parambgin)])
    {
      this.jdField_a_of_type_ArrayOfBoolean = parambgin;
      return;
    }
  }
  
  public OutputStream a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= bgin.a(this.jdField_a_of_type_Bgin))) {
      throw new IllegalArgumentException("Expected index " + paramInt + " to be greater than 0 and less than the maximum value count of " + bgin.a(this.jdField_a_of_type_Bgin));
    }
    synchronized (this.jdField_a_of_type_Bgin)
    {
      if (bgis.a(this.jdField_a_of_type_Bgis) != this) {
        throw new IllegalStateException();
      }
    }
    if (!bgis.a(this.jdField_a_of_type_Bgis)) {
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    File localFile = this.jdField_a_of_type_Bgis.b(paramInt);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new bgir(this, (OutputStream)localObject2, null);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        bgin.a(this.jdField_a_of_type_Bgin).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = bgin.a();
          return localOutputStream;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bgin.a(this.jdField_a_of_type_Bgin, this, false);
      this.jdField_a_of_type_Bgin.a(bgis.a(this.jdField_a_of_type_Bgis));
    }
    for (;;)
    {
      this.b = true;
      return;
      bgin.a(this.jdField_a_of_type_Bgin, this, true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(a(paramInt), bgiu.b);
      bgiu.a(localOutputStreamWriter);
    }
    finally
    {
      try
      {
        localOutputStreamWriter.write(paramString);
        bgiu.a(localOutputStreamWriter);
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
    bgin.a(this.jdField_a_of_type_Bgin, this, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgiq
 * JD-Core Version:    0.7.0.1
 */