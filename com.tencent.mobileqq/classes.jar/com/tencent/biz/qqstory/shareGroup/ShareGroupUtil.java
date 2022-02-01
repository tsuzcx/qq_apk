package com.tencent.biz.qqstory.shareGroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.CircleTransformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class ShareGroupUtil
{
  public static void a(Context paramContext, LinearLayout paramLinearLayout, int paramInt1, QQUserUIItem paramQQUserUIItem, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1 = LayoutInflater.from(paramContext);
    int i = UIUtils.a(paramContext, paramInt1);
    if ((paramInt2 == 1) && (paramBoolean))
    {
      localObject2 = ((LayoutInflater)localObject1).inflate(2131561767, null);
      localObject3 = (TextView)((View)localObject2).findViewById(2131379066);
      if (paramInt3 > 99)
      {
        localObject1 = "99+";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt3);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
      ((TextView)localObject3).setVisibility(0);
      localObject1 = ((View)localObject2).findViewById(2131368503);
      localObject3 = ((View)localObject1).getLayoutParams();
      paramInt1 = UIUtils.a(paramContext, paramInt1 - 2);
      ((ViewGroup.LayoutParams)localObject3).height = paramInt1;
      ((ViewGroup.LayoutParams)localObject3).width = paramInt1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131561766, null);
    }
    Object localObject2 = (CircleImageView)((View)localObject1).findViewById(2131368502);
    Object localObject3 = ((CircleImageView)localObject2).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject3).height = i;
    ((ViewGroup.LayoutParams)localObject3).width = i;
    ((CircleImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((CircleImageView)localObject2).setBorderColor(-1);
    ((CircleImageView)localObject2).setBorderWidth(UIUtils.a(paramContext, 1.0F));
    UIUtils.a((ImageView)localObject2, paramQQUserUIItem.headUrl, i, i, new CircleTransformation(null, null));
    paramQQUserUIItem = new LinearLayout.LayoutParams(i, i);
    if (paramInt2 != -1) {
      paramQQUserUIItem.setMargins(-AIOUtils.b(8.0F, paramContext.getResources()), 0, 0, 0);
    }
    paramLinearLayout.addView((View)localObject1, paramQQUserUIItem);
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/testserver");
    return new File(localStringBuilder.toString()).exists();
  }
  
  public static boolean a(ShareGroupItem paramShareGroupItem)
  {
    int i = ((StoryConfigManager)SuperManager.a(10)).a();
    boolean bool3 = paramShareGroupItem.isPublic();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      if ((i & 0x1) != 0) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if ((i & 0x2) != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(ShareGroupFeedItem paramShareGroupFeedItem)
  {
    if (paramShareGroupFeedItem != null)
    {
      paramShareGroupFeedItem = paramShareGroupFeedItem.getOwner();
      if ((paramShareGroupFeedItem != null) && (paramShareGroupFeedItem.type == 2))
      {
        SLog.b("ShareGroupUtil", "屏蔽掉圈子类型 %s", paramShareGroupFeedItem);
        return true;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    return (((StoryConfigManager)SuperManager.a(10)).a() & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.ShareGroupUtil
 * JD-Core Version:    0.7.0.1
 */