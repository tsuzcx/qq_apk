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

public class bnje
{
  public static int a;
  PKManager jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 1280;
  }
  
  private void a(bnjg parambnjg, DecodeConfig paramDecodeConfig, axqz paramaxqz, PublishVideoEntry paramPublishVideoEntry)
  {
    boolean bool1 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
    int k = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getIntExtra("video_rotation", 0);
    boolean bool2 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
    int i;
    int j;
    if (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
    {
      i = 1;
      if (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 14) {
        break label415;
      }
      j = 1;
      label65:
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, new Object[] { "before adjust rotation:", Integer.valueOf(k), ", isLocalImport:", Boolean.valueOf(bool1) });
        QLog.d("MergeEditVideo", 2, "before adjust config: " + paramaxqz.toString());
      }
      if (!bool1) {
        break label497;
      }
      if (k != 0)
      {
        paramaxqz.h = k;
        if ((i == 0) && (j == 0)) {
          break label421;
        }
        paramaxqz.g = 0;
      }
      label166:
      j = paramaxqz.jdField_a_of_type_Int;
      i = paramaxqz.b;
      if (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 14) {
        break label444;
      }
      j = Math.min(paramaxqz.jdField_a_of_type_Int, paramaxqz.b);
      i = Math.max(paramaxqz.jdField_a_of_type_Int, paramaxqz.b);
      label216:
      int m = i;
      k = j;
      if (i > jdField_a_of_type_Int)
      {
        k = (int)(j * jdField_a_of_type_Int / i);
        m = jdField_a_of_type_Int;
      }
      paramaxqz.jdField_a_of_type_Int = axld.a(k);
      paramaxqz.b = axld.a(m);
      paramDecodeConfig.width = paramaxqz.jdField_a_of_type_Int;
      paramDecodeConfig.height = paramaxqz.b;
      if ((paramaxqz.c) || (paramaxqz.jdField_e_of_type_Boolean))
      {
        k = paramaxqz.jdField_a_of_type_Int;
        m = (int)(paramaxqz.jdField_a_of_type_Int * 16.0F / 9.0F);
        j = m;
        i = k;
        if (m > jdField_a_of_type_Int)
        {
          i = (int)(k * jdField_a_of_type_Int / m);
          j = jdField_a_of_type_Int;
        }
        paramaxqz.jdField_a_of_type_Int = axld.a(i);
        paramaxqz.b = axld.a(j);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramaxqz.toString());
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
        paramaxqz.g = 270;
        break label166;
      }
      paramaxqz.g = 0;
      break label166;
      label444:
      if ((paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) || (!bool2))
      {
        j = Math.min(paramaxqz.jdField_a_of_type_Int, paramaxqz.b);
        i = Math.max(paramaxqz.jdField_a_of_type_Int, paramaxqz.b);
        break label216;
      }
      paramaxqz.f = false;
      break label216;
      label497:
      if (i != 0) {
        paramaxqz.g = 0;
      }
    }
  }
  
  private void a(bnmc parambnmc, HWVideoDecoder paramHWVideoDecoder, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry != null)
    {
      boolean bool = paramPublishVideoEntry.getBooleanExtra("has_game_pk_filter", false);
      String str1 = paramPublishVideoEntry.getStringExtra("game_pk_video_path", "");
      String str2 = paramPublishVideoEntry.getStringExtra("game_pk_cover_path", "");
      String str3 = paramPublishVideoEntry.getStringExtra("game_pk_result_path", "");
      if ((bool) && (!TextUtils.isEmpty(str2)) && (FileUtil.fileExistsAndNotEmpty(str2)))
      {
        parambnmc = parambnmc.a();
        if (!parambnmc.hasQQFilter(183)) {
          parambnmc.pushChainBasedStackTopChain(183, null);
        }
        parambnmc = (PKFilter)parambnmc.getQQFilterByType(183);
        if (parambnmc != null)
        {
          parambnmc.enableDebug(false);
          parambnmc.config(str1, str2, str3, paramPublishVideoEntry.videoDuration, true);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKManager = new PKManager(paramHWVideoDecoder, parambnmc.getPKDecoder());
          parambnmc.prepare();
        }
        return;
      }
      wsv.e(PKFilter.TAG_ENCODE, "is pkVideo=" + bool + " path is empty file :" + str1);
      return;
    }
    wsv.d(PKFilter.TAG_ENCODE, "pk video path is null");
  }
  
  public static boolean a(PublishVideoEntry paramPublishVideoEntry)
  {
    return (paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath));
  }
  
  public int a(String arg1, String paramString2, bnjg parambnjg, PublishVideoEntry paramPublishVideoEntry)
  {
    int i;
    if ((parambnjg == null) || (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null))
    {
      i = -1;
      return i;
    }
    parambnjg.a(parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
    boolean bool1 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("hasAVFilter", false);
    Object localObject4 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONArrayExtra("jsonAVFilterData");
    String str = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("transfer_effect_data", null);
    boolean bool4 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
    boolean bool2 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_follow_capture_video", false);
    boolean bool3 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_video_forward", false);
    Object localObject3 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("follow_capture_param");
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
      boolean bool5 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("has_game_pk_filter", false);
      if ((parambnjg.c == 0) && (!bool5) && (parambnjg.b == 0) && (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (!bool1) && (str == null) && (!bool4) && (!parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments)) && (!bool2) && (!bool3)) {}
      Object localObject2;
      int m;
      int n;
      int i1;
      for (bool1 = true;; bool1 = false)
      {
        localObject2 = new bnnu();
        j = bnnt.a(???, (bnnu)localObject2);
        i = j;
        if (j != 0) {
          break;
        }
        m = localObject2.a[0];
        n = localObject2.a[1];
        i1 = localObject2.a[2];
        if (a(parambnjg, paramPublishVideoEntry, m, n, bool1)) {
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
      i = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
      int j = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
      if (parambnjg.c == 5)
      {
        localObject2 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
        j = 0;
        i = 0;
      }
      for (;;)
      {
        int k;
        if (localObject1 != null)
        {
          bhmu.jdField_a_of_type_Boolean = true;
          JSONObject localJSONObject = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
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
          ??? = new bnmc((List)localObject1, ???, m, n, null);
          if ((a(paramPublishVideoEntry)) || (paramPublishVideoEntry.isMixOriginal))
          {
            QLog.d("MergeEditVideo", 1, "useHwAudioRecorder");
            localObject1 = new bnjj();
            paramString2 = new axqz(paramString2, m, n, parambnjg.jdField_a_of_type_Int, 1, 30, parambnjg.b, false, i1, parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, null, parambnjg.jdField_a_of_type_Boolean);
            localObject2 = new DecodeConfig((String)localObject2, parambnjg.c, false, true, i, j);
            ((DecodeConfig)localObject2).width = m;
            ((DecodeConfig)localObject2).height = n;
            paramString2.c = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("extra_is_need_gaussion_blur", false);
            if (bool3)
            {
              paramString2.jdField_e_of_type_Boolean = true;
              paramString2.l = paramString2.jdField_a_of_type_Int;
              paramString2.m = paramString2.b;
              paramString2.jdField_e_of_type_JavaLangString = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("video_forward_watermark", "");
            }
            a(parambnjg, (DecodeConfig)localObject2, paramString2, paramPublishVideoEntry);
            ((DecodeConfig)localObject2).isLocal = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
            ((DecodeConfig)localObject2).isLandscape = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
            ((DecodeConfig)localObject2).adjustRotation = i1;
            paramString2.j = parambnjg.d;
            paramString2.k = parambnjg.e;
            if ((parambnjg.d == -1) && (paramPublishVideoEntry.getBooleanExtra("composite_key_bitrate_mode", false))) {
              paramString2.j = 0;
            }
            if (bool2)
            {
              paramString2.d = true;
              localObject4 = xom.a(m, n, azgq.jdField_a_of_type_Int, azgq.b);
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
              ((DecodeConfig)localObject2).prolongToTime = axqk.a(parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("game_pk_video_path", ""));
              ((DecodeConfig)localObject2).syncDecode = true;
              ((bnjh)localObject1).a(???.a());
              a(???, ((bnjh)localObject1).a(), parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
            }
            localObject3 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
            if (localObject3 != null) {
              ((bnjh)localObject1).a(bmtv.a((String)localObject3));
            }
            parambnjg = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("tracker_Sticker_data", null);
            if (parambnjg != null) {
              ((bnjh)localObject1).b(TrackerStickerParam.FromString(parambnjg));
            }
            if (str != null) {
              ((bnjh)localObject1).b(str);
            }
            ((bnjh)localObject1).a((DecodeConfig)localObject2, paramString2, new bnjf(this, ???, paramString2, paramPublishVideoEntry, (bnjh)localObject1), ???);
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
                  bhmu.jdField_a_of_type_Boolean = true;
                  localObject4 = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
                  ??? = null;
                  if (localObject4 != null) {
                    ??? = new MusicItemInfo((JSONObject)localObject4);
                  }
                  ??? = new bnmc((List)localObject1, ???, m, n, parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
                  break label514;
                }
                ??? = null;
                break label514;
                localObject1 = new bnjh();
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
        if (((bnjh)localObject1).jdField_a_of_type_Int == 0) {
          return 0;
        }
        return 1;
        localObject2 = ???;
      }
    }
  }
  
  public boolean a(bnjg parambnjg, PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
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
      } while ((parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart > 0) || (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd < l));
      if ((parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 11) && (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 12) && (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 1) && (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 14)) {
        return false;
      }
      paramBoolean = parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
      if (Math.max(paramInt1, paramInt2) <= jdField_a_of_type_Int) {}
      for (paramInt1 = 1; (paramInt1 != 0) && ((parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 11) || (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12)); paramInt1 = 0) {
        return false;
      }
    } while ((paramInt1 == 0) || (paramBoolean) || (parambnjg.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 1));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnje
 * JD-Core Version:    0.7.0.1
 */