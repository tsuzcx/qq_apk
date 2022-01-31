import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class beib
{
  private final beid jdField_a_of_type_Beid;
  private boolean jdField_a_of_type_Boolean;
  private final boolean[] jdField_a_of_type_ArrayOfBoolean;
  private boolean b;
  
  private beib(behy parambehy, beid parambeid)
  {
    this.jdField_a_of_type_Beid = parambeid;
    if (beid.a(parambeid)) {}
    for (parambehy = null;; parambehy = new boolean[behy.a(parambehy)])
    {
      this.jdField_a_of_type_ArrayOfBoolean = parambehy;
      return;
    }
  }
  
  public OutputStream a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= behy.a(this.jdField_a_of_type_Behy))) {
      throw new IllegalArgumentException("Expected index " + paramInt + " to be greater than 0 and less than the maximum value count of " + behy.a(this.jdField_a_of_type_Behy));
    }
    synchronized (this.jdField_a_of_type_Behy)
    {
      if (beid.a(this.jdField_a_of_type_Beid) != this) {
        throw new IllegalStateException();
      }
    }
    if (!beid.a(this.jdField_a_of_type_Beid)) {
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    File localFile = this.jdField_a_of_type_Beid.b(paramInt);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new beic(this, (OutputStream)localObject2, null);
      return localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        behy.a(this.jdField_a_of_type_Behy).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = behy.a();
          return localOutputStream;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      behy.a(this.jdField_a_of_type_Behy, this, false);
      this.jdField_a_of_type_Behy.a(beid.a(this.jdField_a_of_type_Beid));
    }
    for (;;)
    {
      this.b = true;
      return;
      behy.a(this.jdField_a_of_type_Behy, this, true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(a(paramInt), beif.b);
      beif.a(localOutputStreamWriter);
    }
    finally
    {
      try
      {
        localOutputStreamWriter.write(paramString);
        beif.a(localOutputStreamWriter);
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
    behy.a(this.jdField_a_of_type_Behy, this, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beib
 * JD-Core Version:    0.7.0.1
 */