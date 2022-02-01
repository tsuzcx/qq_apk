import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bajf
{
  private baim jdField_a_of_type_Baim;
  private bajg jdField_a_of_type_Bajg;
  private bhik jdField_a_of_type_Bhik;
  private boolean jdField_a_of_type_Boolean;
  
  public bajf(QQRecorder.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.jdField_a_of_type_Baim == null)
      {
        this.jdField_a_of_type_Bajg = new bajg();
        this.jdField_a_of_type_Baim = new baim();
        this.jdField_a_of_type_Baim.a(new SilkCodecWrapper(BaseApplication.getContext()));
        this.jdField_a_of_type_Baim.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.b, paramRecorderParam.c);
        this.jdField_a_of_type_Baim.a(this.jdField_a_of_type_Bajg);
      }
      if ((this.jdField_a_of_type_Bhik == null) || (this.jdField_a_of_type_Bhik.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Bhik = new bhik();
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Bhik.c();
        }
        for (;;)
        {
          this.jdField_a_of_type_Bhik.a();
          return;
          this.jdField_a_of_type_Bhik.d();
        }
      }
      return;
    }
    catch (IOException paramRecorderParam)
    {
      paramRecorderParam.printStackTrace();
    }
  }
  
  public baji a(byte[] paramArrayOfByte)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject = new ArrayList();
        int i = 0;
        baij localbaij;
        if (i < paramArrayOfByte.length)
        {
          int k = Math.min(paramArrayOfByte.length - i, 6400);
          localbaij = this.jdField_a_of_type_Baim.a(paramArrayOfByte, i, k);
          i += k;
          ((List)localObject).add(localbaij);
        }
        else
        {
          long l2;
          i = 2000;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
        return paramArrayOfByte;
        paramArrayOfByte = ((List)localObject).iterator();
        i = 0;
        if (paramArrayOfByte.hasNext())
        {
          i = ((baij)paramArrayOfByte.next()).jdField_a_of_type_Int + i;
        }
        else
        {
          paramArrayOfByte = new byte[i];
          localObject = ((List)localObject).iterator();
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            localbaij = (baij)((Iterator)localObject).next();
            System.arraycopy(localbaij.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, i, localbaij.jdField_a_of_type_Int);
            i = localbaij.jdField_a_of_type_Int + i;
          }
          else
          {
            l2 = System.currentTimeMillis();
            bakl.a("VoiceBeanProcessor", "silk encode time:" + (l2 - l1));
            if (this.jdField_a_of_type_Bajg != null)
            {
              i = this.jdField_a_of_type_Bajg.a();
              paramArrayOfByte = new baji(paramArrayOfByte, i);
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Baim != null)
      {
        this.jdField_a_of_type_Baim.a();
        this.jdField_a_of_type_Baim = null;
      }
      if (this.jdField_a_of_type_Bhik != null)
      {
        this.jdField_a_of_type_Bhik.b();
        this.jdField_a_of_type_Bhik = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    finally {}
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Bhik.a(paramArrayOfByte, this.jdField_a_of_type_Boolean);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajf
 * JD-Core Version:    0.7.0.1
 */