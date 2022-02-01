package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQTroopNoticeModule")
public class QQTroopNoticeModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQTroopNoticeModule";
  private BroadcastReceiver mCallReceiver;
  
  public QQTroopNoticeModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="showPicture")
  public void showPicture(String paramString, Promise paramPromise)
  {
    Object localObject1 = getFragment();
    if (localObject1 == null)
    {
      QLog.e("QQTroopNoticeModule", 1, "showPicture fragment is null");
      return;
    }
    localObject1 = ((QBaseFragment)localObject1).getQBaseActivity();
    if (!(localObject1 instanceof QBaseActivity))
    {
      QLog.e("QQTroopNoticeModule", 1, "showPicture activity isvnot QBaseActivity");
      return;
    }
    QBaseActivity localQBaseActivity = (QBaseActivity)localObject1;
    Object localObject8;
    label1065:
    label1072:
    label1078:
    do
    {
      boolean bool1;
      do
      {
        for (;;)
        {
          Object localObject5;
          try
          {
            Object localObject6 = new JSONObject(paramString);
            Object localObject7 = ((JSONObject)localObject6).optString("bigurl");
            int i;
            if (!TextUtils.isEmpty((CharSequence)localObject7))
            {
              paramString = ((JSONObject)localObject6).optString("videoID");
              localObject1 = ((JSONObject)localObject6).optString("videoURL");
              ((JSONObject)localObject6).optString("originalVideoURL");
              i = ((JSONObject)localObject6).optInt("videoWidth");
              j = ((JSONObject)localObject6).optInt("videoHeight");
              ((JSONObject)localObject6).optBoolean("isLike");
              localObject2 = QZoneHelper.UserInfo.getInstance();
              localObject3 = new Bundle();
              localObject4 = new ArrayList();
              localObject5 = new PhotoInfo();
              ((PhotoInfo)localObject5).bigUrl = ((String)localObject7);
              ((PhotoInfo)localObject5).videoflag = 1;
              ((PhotoInfo)localObject5).videodata = new VideoInfo();
              ((PhotoInfo)localObject5).videodata.videoId = paramString;
              localObject8 = new PictureUrl();
              ((PictureUrl)localObject8).url = ((String)localObject7);
              ((PhotoInfo)localObject5).videodata.coverUrl = ((PictureUrl)localObject8);
              localObject7 = new VideoUrl();
              ((VideoUrl)localObject7).url = ((String)localObject1);
              ((PhotoInfo)localObject5).videodata.videoId = paramString;
              ((PhotoInfo)localObject5).videodata.actionUrl = ((String)localObject1);
              ((PhotoInfo)localObject5).videodata.videoUrl = ((VideoUrl)localObject7);
              ((PhotoInfo)localObject5).videodata.width = i;
              ((PhotoInfo)localObject5).videodata.height = j;
              ((PhotoInfo)localObject5).videodata.videoStatus = 5;
              ((ArrayList)localObject4).add(localObject5);
              ((Bundle)localObject3).putSerializable("picturelist", (Serializable)localObject4);
              ((Bundle)localObject3).putInt("curindex", 0);
              ((Bundle)localObject3).putInt("mode", 3);
              ((Bundle)localObject3).putBoolean("need_clear_cache", true);
              QZoneHelper.forwardToPictureViewer(localQBaseActivity, (QZoneHelper.UserInfo)localObject2, (Bundle)localObject3, 6);
            }
            localObject2 = ((JSONObject)localObject6).optJSONArray("imageIDs");
            localObject8 = ((JSONObject)localObject6).optJSONArray("likes");
            localObject7 = ((JSONObject)localObject6).optJSONArray("descs");
            Object localObject4 = ((JSONObject)localObject6).optJSONArray("sourceIDs");
            JSONArray localJSONArray = ((JSONObject)localObject6).optJSONArray("sourceSize");
            bool1 = ((JSONObject)localObject6).optBoolean("needBottomBar");
            paramString = ((JSONObject)localObject6).optJSONObject("extra");
            if (paramString == null) {
              paramString = "";
            } else {
              paramString = paramString.toString();
            }
            int k = ((JSONObject)localObject6).optInt("index");
            String str = ((JSONObject)localObject6).optString("srcID");
            boolean bool2 = Boolean.valueOf(((JSONObject)localObject6).optBoolean("isReport")).booleanValue();
            Object localObject3 = null;
            if (bool2)
            {
              localObject1 = new PublicAccountShowPictureReport();
              ((PublicAccountShowPictureReport)localObject1).parse((JSONObject)localObject6);
              bool2 = ((JSONObject)localObject6).optBoolean("isNotShowIndex", true);
              if (localObject2 != null)
              {
                if (((JSONArray)localObject2).length() == 0) {
                  return;
                }
                if (getAppInterface() == null) {
                  return;
                }
                ArrayList localArrayList = new ArrayList();
                j = ((JSONArray)localObject2).length();
                i = 0;
                if (i < j)
                {
                  localArrayList.add(((JSONArray)localObject2).get(i).toString());
                  i += 1;
                  continue;
                }
                if (localObject4 == null) {
                  break label1072;
                }
                localObject5 = new ArrayList();
                j = ((JSONArray)localObject4).length();
                i = 0;
                localObject2 = localObject4;
                if (i >= j) {
                  break label1065;
                }
                ((ArrayList)localObject5).add(((JSONArray)localObject2).get(i).toString());
                i += 1;
                continue;
                if (localJSONArray != null)
                {
                  localObject3 = new ArrayList();
                  i = localJSONArray.length();
                  j = 0;
                  if (j >= i) {
                    break label1078;
                  }
                  ((ArrayList)localObject3).add(localJSONArray.get(j).toString());
                  j += 1;
                  continue;
                }
                boolean bool3 = ((JSONObject)localObject6).optBoolean("showTitle", false);
                localObject4 = Base64Util.encodeToString(((JSONObject)localObject6).optString("title", "").getBytes(), 0);
                localObject5 = ((JSONObject)localObject6).optString("articleUrl", "");
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("QQTroopNoticeModule", 2, new Object[] { "KANDIAN Grid Image title: ", localObject4, ", articleUrl: ", localObject5, ", showTitle: ", Boolean.valueOf(bool3) });
                break;
                localObject6 = new boolean[((JSONArray)localObject8).length()];
                i = 0;
                if (i < ((JSONArray)localObject8).length())
                {
                  localObject6[i] = ((JSONArray)localObject8).getBoolean(i);
                  i += 1;
                  continue;
                }
                localObject8 = new ArrayList();
                if ((localObject7 != null) && (((JSONArray)localObject7).length() != 0))
                {
                  int m = ((JSONArray)localObject7).length();
                  i = j;
                  if (i < m)
                  {
                    ((ArrayList)localObject8).add(((JSONArray)localObject7).get(i).toString());
                    i += 1;
                    continue;
                  }
                }
                if (this.mCallReceiver == null)
                {
                  this.mCallReceiver = new QQTroopNoticeModule.1(this, paramPromise);
                  paramPromise = new IntentFilter("android.intent.action.WEBJSCALL");
                  localQBaseActivity.registerReceiver(this.mCallReceiver, paramPromise);
                }
                if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                {
                  TroopNoticeJsHandler.a(localQBaseActivity, k, localArrayList, (boolean[])localObject6, (ArrayList)localObject8, bool1, bool2, str, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject5, (String)localObject4, null, paramString);
                  return;
                }
                TroopNoticeJsHandler.a(localQBaseActivity, k, localArrayList, (boolean[])localObject6, (ArrayList)localObject8, bool1, bool2, str, 100, (PublicAccountShowPictureReport)localObject1, null, (ArrayList)localObject2, (ArrayList)localObject3, paramString, true);
                return;
                if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                {
                  TroopNoticeJsHandler.a(localQBaseActivity, k, localArrayList, null, null, false, bool2, str, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject5, (String)localObject4, null, paramString);
                  return;
                }
                TroopNoticeJsHandler.a(localQBaseActivity, k, localArrayList, null, null, false, bool2, str, 100, (PublicAccountShowPictureReport)localObject1, null, paramString);
              }
              return;
            }
          }
          catch (JSONException paramString)
          {
            return;
          }
          localObject1 = null;
          continue;
          Object localObject2 = localObject5;
          continue;
          localObject2 = null;
        }
        int j = 0;
      } while (!bool1);
    } while (localObject8 != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQTroopNoticeModule
 * JD-Core Version:    0.7.0.1
 */