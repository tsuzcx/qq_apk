import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class bdeb
{
  private final bded jdField_a_of_type_Bded;
  private boolean jdField_a_of_type_Boolean;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean;
  private boolean b;
  
  private bdeb(bddy parambddy, bded parambded)
  {
    this.jdField_a_of_type_Bded = parambded;
    if (bded.a(parambded)) {}
    for (parambddy = null;; parambddy = new boolean[bddy.a(parambddy)])
    {
      this.jdField_a_of_type_ArrayOfBoolean = parambddy;
      return;
    }
  }
  
  public OutputStream a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= bddy.a(this.jdField_a_of_type_Bddy))) {
      throw new IllegalArgumentException("Expected index " + paramInt + " to be greater than 0 and less than the maximum value count of " + bddy.a(this.jdField_a_of_type_Bddy));
    }
    synchronized (this.jdField_a_of_type_Bddy)
    {
      if (bded.a(this.jdField_a_of_type_Bded) != this) {
        throw new IllegalStateException();
      }
    }
    if (!bded.a(this.jdField_a_of_type_Bded)) {
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    File localFile = this.jdField_a_of_type_Bded.b(paramInt);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new bdec(this, (OutputStream)localObject2, null);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        bddy.a(this.jdField_a_of_type_Bddy).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = bddy.a();
          return localOutputStream;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bddy.a(this.jdField_a_of_type_Bddy, this, false);
      this.jdField_a_of_type_Bddy.a(bded.a(this.jdField_a_of_type_Bded));
    }
    for (;;)
    {
      this.b = true;
      return;
      bddy.a(this.jdField_a_of_type_Bddy, this, true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(a(paramInt), bdef.b);
      bdef.a(localOutputStreamWriter);
    }
    finally
    {
      try
      {
        localOutputStreamWriter.write(paramString);
        bdef.a(localOutputStreamWriter);
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
    bddy.a(this.jdField_a_of_type_Bddy, this, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdeb
 * JD-Core Version:    0.7.0.1
 */