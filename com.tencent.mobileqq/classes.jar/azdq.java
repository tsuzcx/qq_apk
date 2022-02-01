import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azdq
{
  private azcy jdField_a_of_type_Azcy;
  private azdr jdField_a_of_type_Azdr;
  private bfzs jdField_a_of_type_Bfzs;
  private boolean jdField_a_of_type_Boolean;
  
  public azdq(QQRecorder.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.jdField_a_of_type_Azcy == null)
      {
        this.jdField_a_of_type_Azdr = new azdr();
        this.jdField_a_of_type_Azcy = new azcy();
        this.jdField_a_of_type_Azcy.a(new SilkCodecWrapper(BaseApplication.getContext()));
        this.jdField_a_of_type_Azcy.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.b, paramRecorderParam.c);
        this.jdField_a_of_type_Azcy.a(this.jdField_a_of_type_Azdr);
      }
      if ((this.jdField_a_of_type_Bfzs == null) || (this.jdField_a_of_type_Bfzs.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Bfzs = new bfzs();
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Bfzs.c();
        }
        for (;;)
        {
          this.jdField_a_of_type_Bfzs.a();
          return;
          this.jdField_a_of_type_Bfzs.d();
        }
      }
      return;
    }
    catch (IOException paramRecorderParam)
    {
      paramRecorderParam.printStackTrace();
    }
  }
  
  public azdt a(byte[] paramArrayOfByte)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject = new ArrayList();
        int i = 0;
        azcv localazcv;
        if (i < paramArrayOfByte.length)
        {
          int k = Math.min(paramArrayOfByte.length - i, 6400);
          localazcv = this.jdField_a_of_type_Azcy.a(paramArrayOfByte, i, k);
          i += k;
          ((List)localObject).add(localazcv);
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
          i = ((azcv)paramArrayOfByte.next()).jdField_a_of_type_Int + i;
        }
        else
        {
          paramArrayOfByte = new byte[i];
          localObject = ((List)localObject).iterator();
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            localazcv = (azcv)((Iterator)localObject).next();
            System.arraycopy(localazcv.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, i, localazcv.jdField_a_of_type_Int);
            i = localazcv.jdField_a_of_type_Int + i;
          }
          else
          {
            l2 = System.currentTimeMillis();
            azeu.a("VoiceBeanProcessor", "silk encode time:" + (l2 - l1));
            if (this.jdField_a_of_type_Azdr != null)
            {
              i = this.jdField_a_of_type_Azdr.a();
              paramArrayOfByte = new azdt(paramArrayOfByte, i);
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
      if (this.jdField_a_of_type_Azcy != null)
      {
        this.jdField_a_of_type_Azcy.a();
        this.jdField_a_of_type_Azcy = null;
      }
      if (this.jdField_a_of_type_Bfzs != null)
      {
        this.jdField_a_of_type_Bfzs.b();
        this.jdField_a_of_type_Bfzs = null;
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
      boolean bool = this.jdField_a_of_type_Bfzs.a(paramArrayOfByte, this.jdField_a_of_type_Boolean);
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
 * Qualified Name:     azdq
 * JD-Core Version:    0.7.0.1
 */