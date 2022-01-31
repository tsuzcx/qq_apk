import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.pkvideo.PKManager;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkxu
{
  public static int a;
  PKManager jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 1280;
  }
  
  private void a(bkxw parambkxw, DecodeConfig paramDecodeConfig, avza paramavza, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
    int k = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getIntExtra("video_rotation", 0);
    boolean bool2 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
    int i;
    int j;
    if (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
    {
      i = 1;
      if (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 14) {
        break label415;
      }
      j = 1;
      label65:
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, new Object[] { "before adjust rotation:", Integer.valueOf(k), ", isLocalImport:", Boolean.valueOf(bool1) });
        QLog.d("MergeEditVideo", 2, "before adjust config: " + paramavza.toString());
      }
      if (!bool1) {
        break label497;
      }
      if (k != 0)
      {
        paramavza.h = k;
        if ((i == 0) && (j == 0)) {
          break label421;
        }
        paramavza.g = 0;
      }
      label166:
      j = paramavza.jdField_a_of_type_Int;
      i = paramavza.b;
      if (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14) {
        break label444;
      }
      j = Math.min(paramavza.jdField_a_of_type_Int, paramavza.b);
      i = Math.max(paramavza.jdField_a_of_type_Int, paramavza.b);
      label216:
      int m = i;
      k = j;
      if (i > jdField_a_of_type_Int)
      {
        k = (int)(j * jdField_a_of_type_Int / i);
        m = jdField_a_of_type_Int;
      }
      paramavza.jdField_a_of_type_Int = avte.a(k);
      paramavza.b = avte.a(m);
      paramDecodeConfig.width = paramavza.jdField_a_of_type_Int;
      paramDecodeConfig.height = paramavza.b;
      if ((paramavza.c) || (paramavza.jdField_e_of_type_Boolean))
      {
        k = paramavza.jdField_a_of_type_Int;
        m = (int)(paramavza.jdField_a_of_type_Int * 16.0F / 9.0F);
        j = m;
        i = k;
        if (m > jdField_a_of_type_Int)
        {
          i = (int)(k * jdField_a_of_type_Int / m);
          j = jdField_a_of_type_Int;
        }
        paramavza.jdField_a_of_type_Int = avte.a(i);
        paramavza.b = avte.a(j);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramavza.toString());
      }
      return;
      i = 0;
      break;
      label415:
      j = 0;
      break label65;
      label421:
      if (bool2)
      {
        paramavza.g = 270;
        break label166;
      }
      paramavza.g = 0;
      break label166;
      label444:
      if ((paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) || (!bool2))
      {
        j = Math.min(paramavza.jdField_a_of_type_Int, paramavza.b);
        i = Math.max(paramavza.jdField_a_of_type_Int, paramavza.b);
        break label216;
      }
      paramavza.f = false;
      break label216;
      label497:
      if (i != 0) {
        paramavza.g = 0;
      }
    }
  }
  
  private void a(blas paramblas, HWVideoDecoder paramHWVideoDecoder, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry != null)
    {
      boolean bool = paramPublishVideoEntry.getBooleanExtra("has_game_pk_filter", false);
      String str1 = paramPublishVideoEntry.getStringExtra("game_pk_video_path", "");
      String str2 = paramPublishVideoEntry.getStringExtra("game_pk_cover_path", "");
      String str3 = paramPublishVideoEntry.getStringExtra("game_pk_result_path", "");
      if ((bool) && (!TextUtils.isEmpty(str2)) && (FileUtil.fileExistsAndNotEmpty(str2)))
      {
        paramblas = paramblas.a();
        if (!paramblas.hasQQFilter(183)) {
          paramblas.pushChainBasedStackTopChain(183, null);
        }
        paramblas = (PKFilter)paramblas.getQQFilterByType(183);
        if (paramblas != null)
        {
          paramblas.enableDebug(false);
          paramblas.config(str1, str2, str3, paramPublishVideoEntry.videoDuration, true);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKManager = new PKManager(paramHWVideoDecoder, paramblas.getPKDecoder());
          paramblas.prepare();
        }
        return;
      }
      ved.e(PKFilter.TAG_ENCODE, "is pkVideo=" + bool + " path is empty file :" + str1);
      return;
    }
    ved.d(PKFilter.TAG_ENCODE, "pk video path is null");
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return (paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath));
  }
  
  public int a(String arg1, String paramString2, bkxw parambkxw, PublishVideoEntry paramPublishVideoEntry)
  {
    int i;
    if ((parambkxw == null) || (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null))
    {
      i = -1;
      return i;
    }
    parambkxw.a(parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
    boolean bool1 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("hasAVFilter", false);
    Object localObject4 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONArrayExtra("jsonAVFilterData");
    String str = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("transfer_effect_data", null);
    boolean bool4 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
    boolean bool2 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_follow_capture_video", false);
    boolean bool3 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_video_forward", false);
    Object localObject3 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("follow_capture_param");
    Object localObject1;
    if (localObject4 == null)
    {
      localObject1 = null;
      bool1 = false;
    }
    label128:
    label514:
    label1161:
    for (;;)
    {
      boolean bool5 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("has_game_pk_filter", false);
      if ((parambkxw.c == 0) && (!bool5) && (parambkxw.b == 0) && (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (!bool1) && (str == null) && (!bool4) && (!parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments)) && (!bool2) && (!bool3)) {}
      Object localObject2;
      int m;
      int n;
      int i1;
      for (bool1 = true;; bool1 = false)
      {
        localObject2 = new blck();
        j = blcj.a(???, (blck)localObject2);
        i = j;
        if (j != 0) {
          break;
        }
        m = localObject2.a[0];
        n = localObject2.a[1];
        i1 = localObject2.a[2];
        if (a(parambkxw, paramPublishVideoEntry, m, n, bool1)) {
          break label342;
        }
        QLog.d("MergeEditVideo", 1, "mergeVideo reEncoder false");
        return -1;
        localObject1 = FilterDesc.parse((JSONArray)localObject4);
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          break label1161;
        }
        bool1 = false;
        break label128;
      }
      label342:
      i = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
      int j = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
      if (parambkxw.c == 5)
      {
        localObject2 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
        j = 0;
        i = 0;
      }
      for (;;)
      {
        int k;
        if (localObject1 != null)
        {
          bfma.jdField_a_of_type_Boolean = true;
          JSONObject localJSONObject = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
          ??? = null;
          if (localJSONObject != null) {
            ??? = new MusicItemInfo(localJSONObject);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("MergeEditVideo", 2, "getAVFilterJSONArray " + ((JSONArray)localObject4).toString());
            localObject4 = new StringBuilder().append("getMusicInfo id = ");
            if (??? == null) {
              break label1047;
            }
            k = ???.mItemId;
          }
        }
        for (;;)
        {
          QLog.d("MergeEditVideo", 2, k);
          ??? = new blas((List)localObject1, ???, m, n, null);
          if ((a(paramPublishVideoEntry)) || (paramPublishVideoEntry.isMixOriginal))
          {
            QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
            localObject1 = new bkxz();
            paramString2 = new avza(paramString2, m, n, parambkxw.jdField_a_of_type_Int, 1, 30, parambkxw.b, false, i1, parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, null, parambkxw.jdField_a_of_type_Boolean);
            localObject2 = new DecodeConfig((String)localObject2, parambkxw.c, false, true, i, j);
            ((DecodeConfig)localObject2).width = m;
            ((DecodeConfig)localObject2).height = n;
            paramString2.c = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
            if (bool3)
            {
              paramString2.jdField_e_of_type_Boolean = true;
              paramString2.l = paramString2.jdField_a_of_type_Int;
              paramString2.m = paramString2.b;
              paramString2.jdField_e_of_type_JavaLangString = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("video_forward_watermark", "");
            }
            a(parambkxw, (DecodeConfig)localObject2, paramString2, paramPublishVideoEntry);
            ((DecodeConfig)localObject2).isLocal = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
            ((DecodeConfig)localObject2).isLandscape = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
            ((DecodeConfig)localObject2).adjustRotation = i1;
            paramString2.j = parambkxw.d;
            paramString2.k = parambkxw.e;
            if ((parambkxw.d == -1) && (paramPublishVideoEntry.getBooleanExtra("composite_key_bitrate_mode", false))) {
              paramString2.j = 0;
            }
            if (bool2)
            {
              paramString2.d = true;
              localObject4 = vzu.a(m, n, axlk.jdField_a_of_type_Int, axlk.b);
              paramString2.l = paramString2.jdField_a_of_type_Int;
              paramString2.m = paramString2.b;
              paramString2.jdField_a_of_type_Int = ((Integer)((Pair)localObject4).first).intValue();
              paramString2.b = ((Integer)((Pair)localObject4).second).intValue();
              if (localObject3 != null) {
                paramString2.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = FollowCaptureParam.parseFromJson((JSONObject)localObject3);
              }
            }
            if (bool5)
            {
              ((DecodeConfig)localObject2).prolongToTime = avyl.a(parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("game_pk_video_path", ""));
              ((DecodeConfig)localObject2).syncDecode = true;
              ((bkxx)localObject1).a(???.a());
              a(???, ((bkxx)localObject1).a(), parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
            }
            localObject3 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
            if (localObject3 != null) {
              ((bkxx)localObject1).a(bkil.a((String)localObject3));
            }
            parambkxw = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("tracker_Sticker_data", null);
            if (parambkxw != null) {
              ((bkxx)localObject1).b(TrackerStickerParam.FromString(parambkxw));
            }
            if (str != null) {
              ((bkxx)localObject1).b(str);
            }
            ((bkxx)localObject1).a((DecodeConfig)localObject2, paramString2, new bkxv(this, ???, paramString2, paramPublishVideoEntry, (bkxx)localObject1), ???);
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
                label1047:
                k = -1;
                continue;
                if (bool5)
                {
                  bfma.jdField_a_of_type_Boolean = true;
                  localObject4 = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
                  ??? = null;
                  if (localObject4 != null) {
                    ??? = new MusicItemInfo((JSONObject)localObject4);
                  }
                  ??? = new blas((List)localObject1, ???, m, n, parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
                  break label514;
                }
                ??? = null;
                break label514;
                localObject1 = new bkxx();
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
        if (((bkxx)localObject1).jdField_a_of_type_Int == 0) {
          return 0;
        }
        return 1;
        localObject2 = ???;
      }
    }
  }
  
  public boolean a(bkxw parambkxw, PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    do
    {
      long l;
      do
      {
        do
        {
          return true;
          if (!paramPublishVideoEntry.isLocalPublish) {
            return false;
          }
        } while ((paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)));
        l = ShortVideoUtils.b(paramPublishVideoEntry.mLocalRawVideoDir);
      } while ((parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart > 0) || (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd < l));
      if ((parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 11) && (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 12) && (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 1) && (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 14)) {
        return false;
      }
      paramBoolean = parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
      if (Math.max(paramInt1, paramInt2) <= jdField_a_of_type_Int) {}
      for (paramInt1 = 1; (paramInt1 != 0) && ((parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 11) || (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12)); paramInt1 = 0) {
        return false;
      }
    } while ((paramInt1 == 0) || (paramBoolean) || (parambkxw.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 1));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkxu
 * JD-Core Version:    0.7.0.1
 */