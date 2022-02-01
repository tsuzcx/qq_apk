package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.PageLoadManager;
import com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoConvertUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectVideoPresenter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AlbumUtils.LocalMediaInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo;
  private PageLoadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPageLoadManager = new PageLoadManager();
  private ConditionChecker jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoConditionChecker = new ConditionChecker();
  private ISelectVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoISelectVideoView;
  private SelectVideoUIDelegate jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoUIDelegate = new SelectVideoUIDelegate();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  public SelectVideoPresenter(Activity paramActivity, ISelectVideoView paramISelectVideoView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoISelectVideoView = paramISelectVideoView;
    c();
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject1 = new JSONObject();
    IKanDianPublisher localIKanDianPublisher = (IKanDianPublisher)QRoute.api(IKanDianPublisher.class);
    Object localObject2;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("extra");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        localObject1 = localObject2;
        int i = paramIntent.getIntExtra("key_from", 0);
        localObject2 = paramIntent.getStringExtra("arg_callback");
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.jdField_b_of_type_JavaLangString != null)) {
          localIKanDianPublisher.buildSelectVideoInfo((JSONObject)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.jdField_b_of_type_JavaLangString);
        }
        localIKanDianPublisher.buildPublisherScene((JSONObject)localObject1, i, (String)localObject2);
        localObject2 = (ColumnInfo)paramIntent.getParcelableExtra("key_column_info");
        paramIntent = (Intent)localObject1;
        if (localObject2 != null)
        {
          paramIntent = (Intent)localObject1;
          if (((ColumnInfo)localObject2).valid())
          {
            localIKanDianPublisher.buildVideoOriginTopicInfo((JSONObject)localObject1, ((ColumnInfo)localObject2).columnID, ((ColumnInfo)localObject2).title);
            paramIntent = (Intent)localObject1;
          }
        }
        localIKanDianPublisher.openPublishArticlePageForResult(this.jdField_a_of_type_AndroidAppActivity, 10001, paramIntent);
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("RIJUGC.SelectVideoPresenter", 1, localJSONException.getMessage());
      }
      continue;
      paramIntent = (Intent)localObject1;
    }
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new SavePicTask(paramBitmap, paramString);
    paramBitmap.a(new SelectVideoPresenter.8(this));
    paramBitmap.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoConditionChecker.a("暂不支持该类视频格式", new SelectVideoPresenter.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoConditionChecker.a("视频时长短于5秒，无法上传", new SelectVideoPresenter.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoConditionChecker.a("视频文件不存在", new SelectVideoPresenter.3(this));
    String str = "视频大小超过" + VideoConvertUtil.b() + "，无法上传";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoConditionChecker.a(str, new SelectVideoPresenter.4(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPageLoadManager.a(new SelectVideoPresenter.5(this));
  }
  
  private void d()
  {
    URL localURL = AlbumUtil.generateAlbumVideoThumbURL(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.jdField_b_of_type_JavaLangString, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.e = AbsDownloader.getFilePath(localURL.toString());
    if (new File(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.e).exists())
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      a(ImageUtil.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo.e);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new SelectVideoPresenter.7(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void e()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo == null)
    {
      i = 1;
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoISelectVideoView.a()) {
        break label76;
      }
      AlbumUtils.LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoISelectVideoView.a(i);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoConditionChecker.a(localLocalMediaInfo, null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoISelectVideoView.b(i);
        return;
        i = 0;
        break;
      }
      i += 1;
    }
    label76:
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.SelectVideoPresenter", 2, "not found the select video...");
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694518, 1).a();
  }
  
  private void f()
  {
    a(this.jdField_a_of_type_AndroidAppActivity.getIntent());
  }
  
  private void g()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择一个视频", 0).a();
  }
  
  public SelectVideoUIDelegate a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoUIDelegate;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPageLoadManager.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPageLoadManager.a(paramInt);
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo = paramLocalMediaInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoUIDelegate.a(paramLocalMediaInfo);
  }
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoConditionChecker.a(paramLocalMediaInfo, new SelectVideoPresenter.6(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcAlbumUtils$LocalMediaInfo == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoPresenter
 * JD-Core Version:    0.7.0.1
 */