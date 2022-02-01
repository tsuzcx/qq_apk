import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class brio
  implements brfz, QQSpecialAVFilter.MusicWaveformSupporter
{
  private int jdField_a_of_type_Int;
  private brjl jdField_a_of_type_Brjl;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = boec.a();
  private PKFilter jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public brio(List<FilterDesc> paramList, MusicItemInfo paramMusicItemInfo, int paramInt1, int paramInt2, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramList != null)
    {
      paramPublishVideoEntry = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        if (localFilterDesc != null)
        {
          int i = QQAVImageFilterConstants.getFilterType(localFilterDesc.id);
          if (i == 0)
          {
            this.jdField_a_of_type_Boolean = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 2)
          {
            this.jdField_a_of_type_Boolean = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 5)
          {
            this.jdField_a_of_type_Boolean = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 1)
          {
            this.jdField_a_of_type_Boolean = true;
            paramPublishVideoEntry.clear();
            paramPublishVideoEntry.add(localFilterDesc);
          }
        }
      }
      if (paramPublishVideoEntry.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramPublishVideoEntry);
      }
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(80);
    if ((paramMusicItemInfo != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((QQSpecialAVFilter)paramList.next()).setMusicWaveformSupporter(this);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
      b();
    }
  }
  
  @TargetApi(17)
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
    {
      this.jdField_a_of_type_Brjl = new brjl();
      if (!brjn.a()) {
        break label44;
      }
      this.d = true;
      if (QLog.isColorLevel()) {
        QLog.e("QQEncodeFilterRender", 2, "musicSoundFile create give up, is rubbish Meizu");
      }
    }
    for (;;)
    {
      return;
      label44:
      this.jdField_c_of_type_Boolean = true;
      brip localbrip = new brip(this);
      try
      {
        long l = SystemClock.elapsedRealtimeNanos();
        boolean bool = this.jdField_a_of_type_Brjl.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, localbrip, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQEncodeFilterRender", 2, "createSoundFile time: " + (SystemClock.elapsedRealtimeNanos() - l) / 1000000L + "ms");
        }
        if (!bool)
        {
          this.jdField_a_of_type_Brjl = null;
          if (QLog.isColorLevel())
          {
            QLog.e("QQEncodeFilterRender", 2, "create MusicSoundFile fail");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("QQEncodeFilterRender", 2, localException.toString());
        }
        this.jdField_a_of_type_Brjl = null;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_a_of_type_Int = ((int)(paramLong / 1000000L));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().SetTimeStamp(paramLong, paramLong);
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(paramInt3);
  }
  
  public int a(int paramInt, long paramLong)
  {
    return a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramInt, paramLong);
  }
  
  public QQFilterRenderManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  }
  
  public PKFilter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
    this.jdField_a_of_type_Brjl = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public float getCurrentMusicGain()
  {
    try
    {
      if (this.jdField_a_of_type_Brjl != null)
      {
        if (this.d) {
          return 0.5F;
        }
        float f = this.jdField_a_of_type_Brjl.a(this.jdField_a_of_type_Int);
        return f;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQEncodeFilterRender", 2, "getCurrentMusicGain() error: " + localException.toString());
      }
    }
    return -1.0F;
  }
  
  public MusicItemInfo getMusicItemInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brio
 * JD-Core Version:    0.7.0.1
 */