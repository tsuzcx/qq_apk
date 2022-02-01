package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class QCircleFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static int j = -1;
  private final int jdField_a_of_type_Int;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  
  public QCircleFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = AIOUtils.a(227.0F, paramBaseAdapter);
    this.c = AIOUtils.a(128.0F, paramBaseAdapter);
    this.d = AIOUtils.a(129.0F, paramBaseAdapter);
    this.jdField_e_of_type_Int = AIOUtils.a(128.0F, paramBaseAdapter);
    this.f = AIOUtils.a(98.0F, paramBaseAdapter);
    this.g = AIOUtils.a(64.0F, paramBaseAdapter);
    this.h = AIOUtils.a(4.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 12);
    }
  }
  
  private int a(MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if (paramMessageForQCircleFeed.mediaDatas != null)
    {
      if (paramMessageForQCircleFeed.mediaDatas.size() >= 3) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private Drawable a(Resources paramResources, String paramString)
  {
    paramString = SafeBitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return null;
    }
    byte[] arrayOfByte = paramString.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk(arrayOfByte)) {}
    for (paramResources = new NinePatchDrawable(paramResources, paramString, arrayOfByte, new Rect(), null);; paramResources = new BitmapDrawable(paramResources, paramString)) {
      return paramResources;
    }
  }
  
  private View a(View paramView, QCircleFeedItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558919, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView;
      paramHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362481);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362490));
      paramHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362482));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramHolder.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramHolder.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private static String a(long paramLong)
  {
    return QCircleHostUtil.bigNumberFormatTranfer(paramLong);
  }
  
  private void a(View paramView)
  {
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramView.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private void a(QCircleFeedItemBuilder.Holder paramHolder, int paramInt)
  {
    if (paramHolder == null) {
      return;
    }
    if (paramInt <= 0)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(a(paramInt));
  }
  
  private void a(QCircleFeedItemBuilder.Holder paramHolder, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    switch (a(paramMessageForQCircleFeed))
    {
    }
    for (;;)
    {
      paramMessageForQCircleFeed = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697951, new Object[] { paramMessageForQCircleFeed }));
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMessageForQCircleFeed = ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png");
      if (!FileUtils.b(paramMessageForQCircleFeed)) {
        break label164;
      }
      if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break;
      }
      a(paramHolder.jdField_c_of_type_AndroidViewView);
      return;
      b(paramHolder, paramMessageForQCircleFeed);
      continue;
      c(paramHolder, paramMessageForQCircleFeed);
    }
    ThreadManager.getFileThreadHandler().post(new QCircleFeedItemBuilder.2(this, paramMessageForQCircleFeed, paramHolder));
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838339);
    return;
    label164:
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838339);
  }
  
  private void b()
  {
    String str = ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png");
    if (FileUtils.b(str)) {
      ThreadManager.getFileThreadHandler().post(new QCircleFeedItemBuilder.3(this, str));
    }
  }
  
  private void b(QCircleFeedItemBuilder.Holder paramHolder, int paramInt)
  {
    if (paramHolder == null) {
      return;
    }
    if (paramInt <= 0)
    {
      paramHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    paramHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText(a(paramInt));
  }
  
  private void b(QCircleFeedItemBuilder.Holder paramHolder, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if ((paramMessageForQCircleFeed.mediaDatas == null) || (paramMessageForQCircleFeed.mediaDatas.size() == 0)) {
      return;
    }
    MessageForQCircleFeed.MediaData localMediaData = (MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.mediaUrl);
    }
    Object localObject2 = paramMessageForQCircleFeed.coverImageUrl;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localMediaData.mediaUrl;
    }
    if (paramHolder.jdField_e_of_type_AndroidViewView != null) {
      paramHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHolder.jdField_d_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_d_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362491)).inflate();
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362483));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362492));
      paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362479));
      paramHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362494));
      paramHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362478));
      paramHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362493));
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.jdField_d_of_type_AndroidWidgetTextView, false);
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.jdField_e_of_type_AndroidWidgetTextView, false);
    }
    paramHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (!TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQCircleFeed.content);
    }
    a(paramHolder, paramMessageForQCircleFeed.pushCount);
    b(paramHolder, paramMessageForQCircleFeed.likeCount);
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.c;
    a(paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, (String)localObject1, (URLDrawable.URLDrawableOptions)localObject2, new float[] { this.h, this.h, this.h, this.h, this.h, this.h, this.h, this.h });
    paramHolder = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
    if (paramMessageForQCircleFeed.type == 3) {}
    for (int k = 0;; k = 8)
    {
      paramHolder.setVisibility(k);
      QLog.d("QCircleFeedItemBuilder", 2, "message.pushCount=" + paramMessageForQCircleFeed.pushCount + ",message.likecount=" + paramMessageForQCircleFeed.likeCount);
      return;
    }
  }
  
  private void c(QCircleFeedItemBuilder.Holder paramHolder, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if ((paramMessageForQCircleFeed.mediaDatas == null) || (paramMessageForQCircleFeed.mediaDatas.size() < 3)) {
      return;
    }
    String str1 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0)).mediaUrl;
    String str2 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(1)).mediaUrl;
    String str3 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(2)).mediaUrl;
    if (paramHolder.jdField_d_of_type_AndroidViewView != null) {
      paramHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHolder.jdField_e_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_e_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362489)).inflate();
      paramHolder.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362484));
      paramHolder.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362486));
      paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362485));
      paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362479));
      paramHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362494));
      paramHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362478));
      paramHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362493));
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.jdField_d_of_type_AndroidWidgetTextView, false);
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(paramHolder.jdField_e_of_type_AndroidWidgetTextView, false);
    }
    paramHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (!TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQCircleFeed.content);
    }
    a(paramHolder, paramMessageForQCircleFeed.pushCount);
    b(paramHolder, paramMessageForQCircleFeed.likeCount);
    URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions1.mRequestWidth = this.d;
    localURLDrawableOptions1.mRequestHeight = this.jdField_e_of_type_Int;
    URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions2.mRequestWidth = this.f;
    localURLDrawableOptions2.mRequestHeight = this.g;
    a(paramHolder.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, str1, localURLDrawableOptions1, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h });
    a(paramHolder.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, str2, localURLDrawableOptions2, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
    a(paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, str3, localURLDrawableOptions2, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    QLog.d("QCircleFeedItemBuilder", 2, "message.pushCount=" + paramMessageForQCircleFeed.pushCount + ",message.likecount=" + paramMessageForQCircleFeed.likeCount);
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCircleFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    b();
    paramMessageRecord = (MessageForQCircleFeed)paramMessageRecord;
    paramViewHolder = (QCircleFeedItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramViewHolder.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramViewHolder.jdField_b_of_type_JavaLangString = null;
    a(paramViewHolder, paramMessageRecord);
    paramViewHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(new QCircleFeedItemBuilder.1(this, paramMessageRecord));
    return paramView;
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new QCircleFeedItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(CornerImageView paramCornerImageView, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramCornerImageView.setImageURL(paramString);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleFeedItemBuilder
 * JD-Core Version:    0.7.0.1
 */