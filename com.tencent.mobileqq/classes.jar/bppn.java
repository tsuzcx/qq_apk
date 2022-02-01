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

public class bppn
{
  public static int a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 1280;
  }
  
  private void a(bppp parambppp, DecodeConfig paramDecodeConfig, bbmm parambbmm, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
    int j = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getIntExtra("video_rotation", 0);
    boolean bool2 = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
    int i;
    if (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14)
    {
      i = 1;
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, new Object[] { "before adjust rotation:", Integer.valueOf(j), ", isLocalImport:", Boolean.valueOf(bool1) });
        QLog.d("MergeEditVideo", 2, "before adjust config: " + parambbmm.toString());
      }
      if (bool1)
      {
        if (j != 0)
        {
          parambbmm.h = j;
          if (i == 0) {
            break label389;
          }
          parambbmm.g = 0;
        }
        label147:
        j = parambbmm.jdField_a_of_type_Int;
        i = parambbmm.b;
        if (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14) {
          break label412;
        }
        j = Math.min(parambbmm.jdField_a_of_type_Int, parambbmm.b);
        i = Math.max(parambbmm.jdField_a_of_type_Int, parambbmm.b);
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
      parambbmm.jdField_a_of_type_Int = bbhm.a(k);
      parambbmm.b = bbhm.a(m);
      paramDecodeConfig.width = parambbmm.jdField_a_of_type_Int;
      paramDecodeConfig.height = parambbmm.b;
      if (parambbmm.c)
      {
        k = parambbmm.jdField_a_of_type_Int;
        m = (int)(parambbmm.jdField_a_of_type_Int * 16.0F / 9.0F);
        j = m;
        i = k;
        if (m > jdField_a_of_type_Int)
        {
          i = (int)(k * jdField_a_of_type_Int / m);
          j = jdField_a_of_type_Int;
        }
        parambbmm.jdField_a_of_type_Int = bbhm.a(i);
        parambbmm.b = bbhm.a(j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + parambbmm.toString());
      }
      return;
      i = 0;
      break;
      label389:
      if (bool2)
      {
        parambbmm.g = 270;
        break label147;
      }
      parambbmm.g = 0;
      break label147;
      label412:
      if ((paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) || (!bool2))
      {
        j = Math.min(parambbmm.jdField_a_of_type_Int, parambbmm.b);
        i = Math.max(parambbmm.jdField_a_of_type_Int, parambbmm.b);
      }
      else
      {
        parambbmm.d = false;
      }
    }
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return (paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath));
  }
  
  public int a(String arg1, String paramString2, bppp parambppp, PublishVideoEntry paramPublishVideoEntry)
  {
    int i;
    if ((parambppp == null) || (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null))
    {
      i = -1;
      return i;
    }
    parambppp.a(parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
    boolean bool1 = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("hasAVFilter", false);
    Object localObject3 = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONArrayExtra("jsonAVFilterData");
    String str = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("transfer_effect_data", null);
    boolean bool2 = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
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
      if ((parambppp.c == 0) && (parambppp.b == 0) && (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (!bool1) && (str == null) && (!bool2) && (!parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments))) {}
      Object localObject2;
      int m;
      int n;
      int i1;
      for (bool1 = true;; bool1 = false)
      {
        localObject2 = new bptj();
        j = bpti.a(???, (bptj)localObject2);
        i = j;
        if (j != 0) {
          break;
        }
        m = localObject2.a[0];
        n = localObject2.a[1];
        i1 = localObject2.a[2];
        if (a(parambppp, paramPublishVideoEntry, m, n, bool1)) {
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
      i = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
      int j = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
      if (parambppp.c == 5)
      {
        ??? = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
        j = 0;
        i = 0;
      }
      for (;;)
      {
        int k;
        if (localObject1 != null)
        {
          com.tencent.sveffects.SvEffectSdkInitor.isDovCapture = true;
          JSONObject localJSONObject = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
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
          localObject1 = new bprr((List)localObject1, (MusicItemInfo)localObject2, m, n, null);
          if ((a(paramPublishVideoEntry)) || (paramPublishVideoEntry.isMixOriginal))
          {
            QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
            localObject2 = new bpps();
            paramString2 = new bbmm(paramString2, m, n, parambppp.jdField_a_of_type_Int, 1, 30, parambppp.b, false, i1, parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, null, parambppp.jdField_a_of_type_Boolean);
            ??? = new DecodeConfig(???, parambppp.c, false, true, i, j);
            ???.width = m;
            ???.height = n;
            paramString2.c = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
            a(parambppp, ???, paramString2, paramPublishVideoEntry);
            ???.isLocal = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
            ???.isLandscape = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
            ???.adjustRotation = i1;
            paramString2.j = parambppp.d;
            paramString2.k = parambppp.e;
            if ((parambppp.d == -1) && (paramPublishVideoEntry.getBooleanExtra("composite_key_bitrate_mode", false))) {
              paramString2.j = 0;
            }
            localObject3 = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
            if (localObject3 != null) {
              ((bppq)localObject2).a(bpde.a((String)localObject3));
            }
            parambppp = parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("tracker_Sticker_data", null);
            if (parambppp != null) {
              ((bppq)localObject2).b(TrackerStickerParam.FromString(parambppp));
            }
            if (str != null) {
              ((bppq)localObject2).a(str);
            }
            ((bppq)localObject2).a(???, paramString2, new bppo(this, (bprr)localObject1, paramString2, paramPublishVideoEntry, (bppq)localObject2), (bppr)localObject1);
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
                localObject2 = new bppq();
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
        if (((bppq)localObject2).jdField_a_of_type_Int == 0) {
          return 0;
        }
        return 1;
      }
    }
  }
  
  public boolean a(bppp parambppp, PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
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
        if ((parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart <= 0) && (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd >= l))
        {
          if ((parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 11) && (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 12) && (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 14)) {
            return false;
          }
          parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
          if (Math.max(paramInt1, paramInt2) <= jdField_a_of_type_Int) {}
          for (paramInt1 = 1; (paramInt1 != 0) && ((parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 11) || (parambppp.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12)); paramInt1 = 0) {
            return false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppn
 * JD-Core Version:    0.7.0.1
 */