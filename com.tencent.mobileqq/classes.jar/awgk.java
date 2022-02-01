import android.media.SoundPool;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;

public class awgk
{
  public SoundPool a;
  protected HashMap<String, Integer> a;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      bgkl.a(BaseApplicationImpl.getContext(), false);
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localInteger != null)
      {
        bgkl.a(BaseApplicationImpl.getContext(), false);
        this.jdField_a_of_type_AndroidMediaSoundPool.stop(localInteger.intValue());
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))) {}
    int i;
    do
    {
      File localFile;
      do
      {
        return false;
        localFile = new File(paramString);
      } while (!localFile.exists());
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(1, 3, 0);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (Build.VERSION.SDK_INT >= 8) {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(null);
      }
      i = this.jdField_a_of_type_AndroidMediaSoundPool.load(localFile.getAbsolutePath(), 1);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SoundPoolUtil", 2, "load failure filepath=" + paramString);
    return false;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i));
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        bgkl.a(BaseApplicationImpl.getContext(), true);
        if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
          this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(1, paramInt2, 0);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
          break;
        }
      } while (!a(paramString));
      if (Build.VERSION.SDK_INT >= 8) {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new awgl(this, paramInt1, paramString));
      }
      do
      {
        for (;;)
        {
          return true;
          paramInt1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
          ThreadManager.getTimer().schedule(new SoundPoolUtil.2(this, paramInt1, paramString), 200L);
        }
        paramInt1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
      } while (this.jdField_a_of_type_AndroidMediaSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F) != 0);
    } while (!QLog.isColorLevel());
    QLog.d("SoundPoolUtil", 2, "play failure filepath=" + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgk
 * JD-Core Version:    0.7.0.1
 */