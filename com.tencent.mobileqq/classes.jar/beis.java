import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class beis
{
  private final beiu jdField_a_of_type_Beiu;
  private boolean jdField_a_of_type_Boolean;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean;
  private boolean b;
  
  private beis(beip parambeip, beiu parambeiu)
  {
    this.jdField_a_of_type_Beiu = parambeiu;
    if (beiu.a(parambeiu)) {}
    for (parambeip = null;; parambeip = new boolean[beip.a(parambeip)])
    {
      this.jdField_a_of_type_ArrayOfBoolean = parambeip;
      return;
    }
  }
  
  public OutputStream a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= beip.a(this.jdField_a_of_type_Beip))) {
      throw new IllegalArgumentException("Expected index " + paramInt + " to be greater than 0 and less than the maximum value count of " + beip.a(this.jdField_a_of_type_Beip));
    }
    synchronized (this.jdField_a_of_type_Beip)
    {
      if (beiu.a(this.jdField_a_of_type_Beiu) != this) {
        throw new IllegalStateException();
      }
    }
    if (!beiu.a(this.jdField_a_of_type_Beiu)) {
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    File localFile = this.jdField_a_of_type_Beiu.b(paramInt);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new beit(this, (OutputStream)localObject2, null);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        beip.a(this.jdField_a_of_type_Beip).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = beip.a();
          return localOutputStream;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      beip.a(this.jdField_a_of_type_Beip, this, false);
      this.jdField_a_of_type_Beip.a(beiu.a(this.jdField_a_of_type_Beiu));
    }
    for (;;)
    {
      this.b = true;
      return;
      beip.a(this.jdField_a_of_type_Beip, this, true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(a(paramInt), beiw.b);
      beiw.a(localOutputStreamWriter);
    }
    finally
    {
      try
      {
        localOutputStreamWriter.write(paramString);
        beiw.a(localOutputStreamWriter);
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
    beip.a(this.jdField_a_of_type_Beip, this, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beis
 * JD-Core Version:    0.7.0.1
 */