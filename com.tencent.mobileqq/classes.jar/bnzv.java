import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bnzv
{
  public static int a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 1280;
  }
  
  private void a(bnzx parambnzx, DecodeConfig paramDecodeConfig, bafx parambafx, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
    int j = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getIntExtra("video_rotation", 0);
    boolean bool2 = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
    int i;
    if (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14)
    {
      i = 1;
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, new Object[] { "before adjust rotation:", Integer.valueOf(j), ", isLocalImport:", Boolean.valueOf(bool1) });
        QLog.d("MergeEditVideo", 2, "before adjust config: " + parambafx.toString());
      }
      if (bool1)
      {
        if (j != 0)
        {
          parambafx.h = j;
          if (i == 0) {
            break label389;
          }
          parambafx.g = 0;
        }
        label147:
        j = parambafx.jdField_a_of_type_Int;
        i = parambafx.b;
        if (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14) {
          break label412;
        }
        j = Math.min(parambafx.jdField_a_of_type_Int, parambafx.b);
        i = Math.max(parambafx.jdField_a_of_type_Int, parambafx.b);
      }
    }
    for (;;)
    {
      int m = i;
      int k = j;
      if (i > jdField_a_of_type_Int)
      {
        k = (int)(j * jdField_a_of_type_Int / i);
        m = jdField_a_of_type_Int;
      }
      parambafx.jdField_a_of_type_Int = babd.a(k);
      parambafx.b = babd.a(m);
      paramDecodeConfig.width = parambafx.jdField_a_of_type_Int;
      paramDecodeConfig.height = parambafx.b;
      if (parambafx.c)
      {
        k = parambafx.jdField_a_of_type_Int;
        m = (int)(parambafx.jdField_a_of_type_Int * 16.0F / 9.0F);
        j = m;
        i = k;
        if (m > jdField_a_of_type_Int)
        {
          i = (int)(k * jdField_a_of_type_Int / m);
          j = jdField_a_of_type_Int;
        }
        parambafx.jdField_a_of_type_Int = babd.a(i);
        parambafx.b = babd.a(j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + parambafx.toString());
      }
      return;
      i = 0;
      break;
      label389:
      if (bool2)
      {
        parambafx.g = 270;
        break label147;
      }
      parambafx.g = 0;
      break label147;
      label412:
      if ((paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) || (!bool2))
      {
        j = Math.min(parambafx.jdField_a_of_type_Int, parambafx.b);
        i = Math.max(parambafx.jdField_a_of_type_Int, parambafx.b);
      }
      else
      {
        parambafx.d = false;
      }
    }
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return (paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath));
  }
  
  public int a(String arg1, String paramString2, bnzx parambnzx, PublishVideoEntry paramPublishVideoEntry)
  {
    int i;
    if ((parambnzx == null) || (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null))
    {
      i = -1;
      return i;
    }
    parambnzx.a(parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
    boolean bool1 = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("hasAVFilter", false);
    Object localObject3 = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONArrayExtra("jsonAVFilterData");
    String str = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("transfer_effect_data", null);
    boolean bool2 = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
    Object localObject1;
    if (localObject3 == null)
    {
      localObject1 = null;
      bool1 = false;
    }
    label272:
    label446:
    label843:
    for (;;)
    {
      label86:
      if ((parambnzx.c == 0) && (parambnzx.b == 0) && (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (!bool1) && (str == null) && (!bool2) && (!parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments))) {}
      Object localObject2;
      int m;
      int n;
      int i1;
      for (bool1 = true;; bool1 = false)
      {
        localObject2 = new bodr();
        j = bodq.a(???, (bodr)localObject2);
        i = j;
        if (j != 0) {
          break;
        }
        m = localObject2.a[0];
        n = localObject2.a[1];
        i1 = localObject2.a[2];
        if (a(parambnzx, paramPublishVideoEntry, m, n, bool1)) {
          break label272;
        }
        QLog.d("MergeEditVideo", 1, "mergeVideo reEncoder false");
        return -1;
        localObject1 = FilterDesc.parse((JSONArray)localObject3);
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          break label843;
        }
        bool1 = false;
        break label86;
      }
      i = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
      int j = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
      if (parambnzx.c == 5)
      {
        ??? = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
        j = 0;
        i = 0;
      }
      for (;;)
      {
        int k;
        if (localObject1 != null)
        {
          com.tencent.sveffects.SvEffectSdkInitor.isDovCapture = true;
          JSONObject localJSONObject = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
          localObject2 = null;
          if (localJSONObject != null) {
            localObject2 = new MusicItemInfo(localJSONObject);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MergeEditVideo", 2, "getAVFilterJSONArray " + ((JSONArray)localObject3).toString());
            localObject3 = new StringBuilder().append("getMusicInfo id = ");
            if (localObject2 == null) {
              break label791;
            }
            k = ((MusicItemInfo)localObject2).mItemId;
          }
        }
        for (;;)
        {
          QLog.d("MergeEditVideo", 2, k);
          localObject1 = new bobz((List)localObject1, (MusicItemInfo)localObject2, m, n, null);
          if ((a(paramPublishVideoEntry)) || (paramPublishVideoEntry.isMixOriginal))
          {
            QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
            localObject2 = new boaa();
            paramString2 = new bafx(paramString2, m, n, parambnzx.jdField_a_of_type_Int, 1, 30, parambnzx.b, false, i1, parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, null, parambnzx.jdField_a_of_type_Boolean);
            ??? = new DecodeConfig(???, parambnzx.c, false, true, i, j);
            ???.width = m;
            ???.height = n;
            paramString2.c = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
            a(parambnzx, ???, paramString2, paramPublishVideoEntry);
            ???.isLocal = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
            ???.isLandscape = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
            ???.adjustRotation = i1;
            paramString2.j = parambnzx.d;
            paramString2.k = parambnzx.e;
            if ((parambnzx.d == -1) && (paramPublishVideoEntry.getBooleanExtra("composite_key_bitrate_mode", false))) {
              paramString2.j = 0;
            }
            localObject3 = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
            if (localObject3 != null) {
              ((bnzy)localObject2).a(bnnm.a((String)localObject3));
            }
            parambnzx = parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("tracker_Sticker_data", null);
            if (parambnzx != null) {
              ((bnzy)localObject2).b(TrackerStickerParam.FromString(parambnzx));
            }
            if (str != null) {
              ((bnzy)localObject2).a(str);
            }
            ((bnzy)localObject2).a(???, paramString2, new bnzw(this, (bobz)localObject1, paramString2, paramPublishVideoEntry, (bnzy)localObject2), (bnzz)localObject1);
            if (this.jdField_a_of_type_Boolean) {}
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            bool1 = this.jdField_a_of_type_Boolean;
            if (!bool1) {}
            try
            {
              this.jdField_a_of_type_JavaLangObject.wait();
              if (paramPublishVideoEntry.isCancel)
              {
                return -16;
                k = -1;
                continue;
                localObject1 = null;
                break label446;
                localObject2 = new bnzy();
              }
            }
            catch (InterruptedException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
        }
        if (((bnzy)localObject2).jdField_a_of_type_Int == 0) {
          return 0;
        }
        return 1;
      }
    }
  }
  
  public boolean a(bnzx parambnzx, PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      if (!paramPublishVideoEntry.isLocalPublish) {
        return false;
      }
      if ((!paramPublishVideoEntry.isMuteRecordVoice) || (!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)))
      {
        long l = ShortVideoUtils.b(paramPublishVideoEntry.mLocalRawVideoDir);
        if ((parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart <= 0) && (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd >= l))
        {
          if ((parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 11) && (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 12) && (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 14)) {
            return false;
          }
          parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
          if (Math.max(paramInt1, paramInt2) <= jdField_a_of_type_Int) {}
          for (paramInt1 = 1; (paramInt1 != 0) && ((parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 11) || (parambnzx.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12)); paramInt1 = 0) {
            return false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzv
 * JD-Core Version:    0.7.0.1
 */