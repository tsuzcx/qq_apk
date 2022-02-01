package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder;
import com.tencent.mobileqq.activity.aio.item.view.ApolloIceBreakShow;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class StickerRecBarAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new StickerRecBarAdapter.2(this);
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new StickerRecBarAdapter.1(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private StickerRecManager jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<IStickerRecEmoticon> jdField_a_of_type_JavaUtilList;
  private CopyOnWriteArrayList<ApolloIceBreakShow> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<StickerRecCacheEntity> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private List<StickerReportItem> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  
  public StickerRecBarAdapter(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 7.0F));
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 7.0F));
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Float * 9.0F));
    this.d = ((int)(this.jdField_a_of_type_Float * 8.0F));
    this.e = ((int)(this.jdField_a_of_type_Float * 64.0F));
    this.f = ((int)(this.jdField_a_of_type_Float * 64.0F));
    this.g = ((int)(this.jdField_a_of_type_Float * 6.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130838410);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager = StickerRecManager.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = paramEmotionKeywordHorizonListView;
  }
  
  private int a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    int i;
    if (paramIStickerRecEmoticon == null) {
      i = this.f;
    }
    int j;
    do
    {
      return i;
      if (StickerRecManager.a(paramIStickerRecEmoticon)) {
        return this.f;
      }
      if (!StickerRecManager.b(paramIStickerRecEmoticon)) {
        return this.f;
      }
      paramIStickerRecEmoticon = (StickerRecData)paramIStickerRecEmoticon;
      float f1 = paramIStickerRecEmoticon.g();
      float f2 = paramIStickerRecEmoticon.h();
      float f3 = f1 / f2;
      if ((f3 > 1.777778F) || (f3 < 0.5625F)) {
        return this.f;
      }
      j = (int)(f1 * this.e / f2);
      i = j;
    } while (j != 0);
    return this.f;
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramIStickerRecEmoticon.a();
    paramIStickerRecEmoticon = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramIStickerRecEmoticon = URLDrawable.URLDrawableOptions.obtain();
    }
    paramIStickerRecEmoticon.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramIStickerRecEmoticon.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramIStickerRecEmoticon.mPlayGifImage = true;
    paramIStickerRecEmoticon.mGifRoundCorner = this.g;
    return paramIStickerRecEmoticon;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
  }
  
  private void a(URLDrawable paramURLDrawable, long paramLong)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("first_sticker", String.valueOf(bool));
      paramURLDrawable = paramURLDrawable.getURL();
      if (paramURLDrawable != null) {
        localHashMap.put("sticker_url", paramURLDrawable.toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if (paramIStickerRecEmoticon == null) {}
    do
    {
      return;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
      if (this.h == 1)
      {
        ScenesRecommendItem localScenesRecommendItem = ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localScenesRecommendItem != null) {
          localObject1 = localScenesRecommendItem.c();
        }
      }
      StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject1);
      if (!StickerRecManager.a(paramIStickerRecEmoticon)) {
        break;
      }
      paramIStickerRecEmoticon.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramIStickerRecEmoticon = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramIStickerRecEmoticon == null);
    paramIStickerRecEmoticon.sendMessage(paramIStickerRecEmoticon.obtainMessage(92));
    return;
    Object localObject1 = (StickerRecData)paramIStickerRecEmoticon;
    Object localObject2 = new Intent();
    paramIStickerRecEmoticon = new ArrayList();
    paramIStickerRecEmoticon.add(((StickerRecData)localObject1).m());
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramIStickerRecEmoticon);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject2).putExtra("send_in_background", true);
    ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramIStickerRecEmoticon);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("quick_send_original_md5", ((StickerRecData)localObject1).c());
    ((Intent)localObject2).putExtra("quick_send_original_size", ((StickerRecData)localObject1).b());
    ((Intent)localObject2).putExtra("quick_send_thumb_md5", ((StickerRecData)localObject1).g());
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject2).putExtra("HOT_PIC_HAS_EXTRA", true);
    int i;
    if ((TextUtils.isEmpty(((StickerRecData)localObject1).i())) || (((StickerRecData)localObject1).i().length() <= 100))
    {
      i = 1;
      label377:
      if (i == 0) {
        break label710;
      }
      ((Intent)localObject2).putExtra("key_emotion_source_from", ((StickerRecData)localObject1).e());
      ((Intent)localObject2).putExtra("key_emotion_source_info", ((StickerRecData)localObject1).h());
      ((Intent)localObject2).putExtra("key_emotion_source_weburl", ((StickerRecData)localObject1).i());
      ((Intent)localObject2).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject2).putExtra("key_emotion_source_packagename", ((StickerRecData)localObject1).j());
      ((Intent)localObject2).putExtra("key_emotion_source_epid", ((StickerRecData)localObject1).f());
      label457:
      if (QLog.isColorLevel()) {
        QLog.i("StickerRecBarAdapter", 2, "md5:" + ((StickerRecData)localObject1).c() + "srcfrom:" + ((StickerRecData)localObject1).e() + ", desc:" + ((StickerRecData)localObject1).h() + ", webUrl:" + ((StickerRecData)localObject1).i() + ", pack:" + ((StickerRecData)localObject1).j() + ", epid:" + ((StickerRecData)localObject1).f());
      }
      if (!((SpecWordEmotionThinkHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(41)).a()) {
        break label756;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
      localObject2 = TroopUtils.a((Editable)localObject1);
      ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIStickerRecEmoticon, false, (String)((Pair)localObject2).first, (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
      TroopPobingItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1.toString(), (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramIStickerRecEmoticon = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramIStickerRecEmoticon == null) {
        break;
      }
      paramIStickerRecEmoticon.sendMessage(paramIStickerRecEmoticon.obtainMessage(92));
      return;
      i = 0;
      break label377;
      label710:
      ReportController.b(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break label457;
      }
      QLog.i("StickerRecBarAdapter", 2, "sendPic over limited!");
      break label457;
      label756:
      ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, null), 8, null, false);
    }
  }
  
  private void a(StickerRecBarAdapter.ViewHolder paramViewHolder)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow);
      }
      return;
    }
  }
  
  private void a(StickerRecBarAdapter.ViewHolder paramViewHolder, StickerRecData paramStickerRecData)
  {
    if (paramStickerRecData == null) {
      return;
    }
    String str = paramStickerRecData.e();
    if (QLog.isColorLevel()) {
      if ("updateApolloView cmsString = " + str != null) {
        break label84;
      }
    }
    for (paramStickerRecData = "null";; paramStickerRecData = str)
    {
      QLog.d("StickerRecBarAdapter", 2, paramStickerRecData);
      if (StringUtil.a(str)) {
        break;
      }
      try
      {
        paramStickerRecData = new JSONObject(str);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a(paramStickerRecData, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramViewHolder.b();
        return;
      }
      catch (JSONException paramViewHolder)
      {
        label84:
        paramViewHolder.printStackTrace();
      }
    }
  }
  
  private void b(StickerRecBarAdapter.ViewHolder paramViewHolder)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow);
      }
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a()) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.c();
      }
      return;
    }
  }
  
  private void c(StickerRecBarAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if ((paramViewHolder == null) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecBarAdapter", 2, "sendPic data is null");
      }
      return;
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  private void d()
  {
    int j = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilList.size() < 5) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 5)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      if (j < i)
      {
        IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localIStickerRecEmoticon == null) {}
        for (;;)
        {
          j += 1;
          break;
          URLDrawable localURLDrawable = localIStickerRecEmoticon.a(localIStickerRecEmoticon.a(), a(localIStickerRecEmoticon));
          if (localURLDrawable != null) {
            if (((localIStickerRecEmoticon instanceof StickerRecData)) && (((StickerRecData)localIStickerRecEmoticon).e() == 3))
            {
              this.jdField_a_of_type_Boolean = true;
            }
            else
            {
              localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
              localURLDrawable.setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
              if (localURLDrawable.getStatus() != 1)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(localURLDrawable);
                localURLDrawable.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                localURLDrawable.addHeader("emo_big", "true");
                localURLDrawable.startDownload();
              }
              else
              {
                this.jdField_a_of_type_Boolean = true;
              }
            }
          }
        }
      }
      a();
      return;
    }
  }
  
  private void e()
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        localStringBuilder1.append("log apolloIceBreakShows list info count = " + j + "\n");
        i = 0;
        if (i < j)
        {
          localObject3 = (ApolloIceBreakShow)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          StringBuilder localStringBuilder2 = new StringBuilder().append("log No.").append(i).append(" apolloIceBreakShow is invisible = ");
          if (((ApolloIceBreakShow)localObject3).a().getVisibility() != 4) {
            break label392;
          }
          bool = true;
          localStringBuilder1.append(bool + "\n");
          i += 1;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView == null)
        {
          QLog.d("StickerRecBarAdapter", 2, localStringBuilder1.toString());
          return;
        }
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getFirstVisiblePosition();
      int j = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getLastVisiblePosition();
      localObject1.append("log mEmotionKeywordList info startIndex = " + i + " | endIndex = " + j + "\n");
      if (i <= j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getChildCount() > i)
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getChild(i);
          if ((??? != null) && (((View)???).getTag() != null)) {
            break label287;
          }
        }
        label287:
        while (!(((View)???).getTag() instanceof StickerRecBarAdapter.ViewHolder))
        {
          i += 1;
          break;
        }
        ??? = (StickerRecBarAdapter.ViewHolder)((View)???).getTag();
        localObject3 = new StringBuilder().append("log No.").append(i).append(" mEmotionKeywordList is invisible = ");
        if (((StickerRecBarAdapter.ViewHolder)???).jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a().getVisibility() == 4) {}
        for (bool = true;; bool = false)
        {
          localObject1.append(bool + "\n");
          break;
        }
      }
      QLog.d("StickerRecBarAdapter", 2, localObject1.toString());
      return;
      label392:
      boolean bool = false;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)((Iterator)localObject).next();
        if (localIStickerRecEmoticon.c()) {
          localArrayList1.add(localIStickerRecEmoticon);
        } else {
          localArrayList2.add(localIStickerRecEmoticon);
        }
      }
      localObject = new StickerReportItem();
      ((StickerReportItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((StickerReportItem)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((StickerReportItem)localObject).jdField_a_of_type_JavaUtilList = localArrayList1;
      ((StickerReportItem)localObject).jdField_b_of_type_JavaUtilList = localArrayList2;
      ((StickerReportItem)localObject).jdField_a_of_type_Int = this.h;
      this.jdField_c_of_type_JavaUtilList.add(localObject);
    }
  }
  
  public void a()
  {
    boolean bool2 = true;
    if (((StickerRecHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(14)).c()) {
      return;
    }
    boolean bool1;
    label34:
    Object localObject;
    if (this.h == 1)
    {
      bool1 = this.jdField_a_of_type_Boolean;
      if (bool1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
        bool1 = bool2;
        if (localObject != null)
        {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(69, this.jdField_c_of_type_JavaLangString));
          bool1 = bool2;
        }
        label69:
        if (!QLog.isColorLevel()) {
          break label180;
        }
        QLog.d("StickerRecBarAdapter", 2, "showEmotionKeywordLayout isshow = " + bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      String str = ((SpecWordEmotionThinkHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(41)).a();
      if (TextUtils.isEmpty(str)) {
        break label182;
      }
      localObject = str;
    }
    label180:
    label182:
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject)))
      {
        bool1 = true;
        break label34;
      }
      bool1 = false;
      break label34;
      bool1 = false;
      break label69;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<IStickerRecEmoticon> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
    }
    do
    {
      return;
      ((StickerRecHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(14)).c();
      QLog.e("StickerRecBarAdapter", 1, "setData");
      this.jdField_a_of_type_JavaUtilList.clear();
      b();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.resetCurrentX(0);
      d();
      notifyDataSetChanged();
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setData:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)paramList.next();
      if ((localIStickerRecEmoticon != null) && (StickerRecManager.b(localIStickerRecEmoticon))) {
        localStringBuilder.append("thumb=").append(((StickerRecData)localIStickerRecEmoticon).b()).append(",");
      }
    }
    QLog.d("StickerRecBarAdapter", 2, localStringBuilder.toString());
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ApolloIceBreakShow)localIterator.next()).c();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    try
    {
      f();
      ArrayList localArrayList1 = new ArrayList(this.jdField_c_of_type_JavaUtilList);
      ArrayList localArrayList2 = new ArrayList(this.jdField_b_of_type_JavaUtilList);
      ThreadManager.getFileThreadHandler().post(new StickerRecBarAdapter.3(this, localArrayList1, localArrayList2));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("StickerRecBarAdapter", 1, "reportData:", localThrowable);
      return;
    }
    finally
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      b();
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.e("StickerRecBarAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_a_of_type_JavaUtilList.size());
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    Object localObject2 = (IStickerRecEmoticon)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    Object localObject3;
    label603:
    boolean bool;
    if (paramView == null)
    {
      localObject1 = new StickerRecBarAdapter.ViewHolder();
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = new EmojiStickerManager.EmotionKeywordLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      paramView = new ViewGroup.LayoutParams(-2, -2);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.d);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setId(2131368865);
      i = a((IStickerRecEmoticon)localObject2);
      paramView = new RelativeLayout.LayoutParams(i, this.e);
      paramView.addRule(13, -1);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView, paramView);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838108));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368865);
      paramView.addRule(8, 2131368865);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131691959);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167197));
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView, paramView);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838404));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368865);
      paramView.addRule(8, 2131368865);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView, paramView);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow = new ApolloIceBreakShow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), this.f, this.e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramView = ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemViewApolloIceBreakShow.a();
      paramView.setId(2131378494);
      localObject3 = new RelativeLayout.LayoutParams(i, this.e);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      paramView.setVisibility(4);
      paramView = ObjectAnimator.ofFloat(((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setDuration(300L);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidAnimationAnimator = paramView;
      paramView = ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(localObject1);
      if (localObject2 != null) {
        break label776;
      }
      QLog.e("StickerRecBarAdapter", 1, "getView stickerRec empty position = " + paramInt);
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((StickerRecBarAdapter.ViewHolder)localObject1).a();
      b((StickerRecBarAdapter.ViewHolder)localObject1);
      label658:
      if (!(localObject2 instanceof StickerRecCameraData)) {
        break label1178;
      }
      ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label675:
      if (!(localObject2 instanceof StickerRecLocalData)) {
        break label1191;
      }
      bool = ((StickerRecLocalData)localObject2).d();
    }
    for (;;)
    {
      label693:
      localObject2 = ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (bool) {}
      for (i = 0;; i = 8)
      {
        ((ImageView)localObject2).setVisibility(i);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangString);
        }
        localObject1 = paramView;
        break;
        localObject1 = (StickerRecBarAdapter.ViewHolder)paramView.getTag();
        i = a((IStickerRecEmoticon)localObject2);
        ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
        break label603;
        label776:
        ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon = ((IStickerRecEmoticon)localObject2);
        if (StickerRecDataUtils.a((IStickerRecEmoticon)localObject2))
        {
          a((StickerRecBarAdapter.ViewHolder)localObject1, (StickerRecData)localObject2);
          paramView.setOnClickListener(this);
          a((StickerRecBarAdapter.ViewHolder)localObject1);
          if (!StickerRecManager.b((IStickerRecEmoticon)localObject2)) {
            break label658;
          }
          ((StickerRecData)localObject2).a(true);
          break label658;
        }
        ((StickerRecBarAdapter.ViewHolder)localObject1).a();
        b((StickerRecBarAdapter.ViewHolder)localObject1);
        localObject3 = ((IStickerRecEmoticon)localObject2).a();
        if (localObject3 == null)
        {
          ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label658;
        }
        localObject3 = ((IStickerRecEmoticon)localObject2).a((URL)localObject3, a((IStickerRecEmoticon)localObject2));
        ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.j);
        ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject2);
        if (((URLDrawable)localObject3).getStatus() != 1)
        {
          ((URLDrawable)localObject3).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          ((URLDrawable)localObject3).addHeader("emo_big", "true");
          ((URLDrawable)localObject3).addHeader("report_key_start_download", String.valueOf(System.currentTimeMillis()));
          if ((((URLDrawable)localObject3).getStatus() == 2) || (((URLDrawable)localObject3).getStatus() == 3)) {
            ((URLDrawable)localObject3).restartDownload();
          }
        }
        for (;;)
        {
          ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject3);
          ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
          ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
          ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
          if (StickerRecManager.b((IStickerRecEmoticon)localObject2))
          {
            ((StickerRecData)localObject2).a(true);
            if (QLog.isColorLevel()) {
              QLog.e("StickerRecBarAdapter", 2, "md5:" + ((StickerRecData)localObject2).c());
            }
          }
          paramView.setOnClickListener(this);
          ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidAnimationAnimator.start();
          break;
          if ((StickerRecManager.b((IStickerRecEmoticon)localObject2)) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(((StickerRecData)localObject2).k())))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(((StickerRecData)localObject2).k());
            String str = ((StickerRecData)localObject2).m();
            this.jdField_b_of_type_JavaUtilList.add(new StickerRecCacheEntity(str, System.currentTimeMillis(), ((StickerRecData)localObject2).k()));
          }
        }
        label1178:
        ((StickerRecBarAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label675;
        label1191:
        if (!(localObject2 instanceof StickerRecFavoriteData)) {
          break label1219;
        }
        bool = ((StickerRecFavoriteData)localObject2).d();
        break label693;
      }
      label1219:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "onClick");
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof StickerRecBarAdapter.ViewHolder)) {}
    for (localObject = (StickerRecBarAdapter.ViewHolder)localObject;; localObject = null)
    {
      if (localObject == null) {}
      label218:
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501)
        {
          e();
          int i;
          if (StickerRecDataUtils.a(((StickerRecBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon))
          {
            c((StickerRecBarAdapter.ViewHolder)localObject);
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label218;
            }
            this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
            this.jdField_a_of_type_AndroidWidgetEditText.setText("");
            if (!StickerRecManager.b(((StickerRecBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon)) {
              break;
            }
            ((StickerRecData)((StickerRecBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon).b(true);
            break;
            if ((((StickerRecBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.getDrawable() instanceof URLDrawable)) {
              if (((URLDrawable)((StickerRecBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.getDrawable()).getStatus() == 1)
              {
                if (this.jdField_a_of_type_AndroidWidgetEditText != null)
                {
                  a(((StickerRecBarAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedIStickerRecEmoticon);
                  i = 1;
                  continue;
                }
                if (QLog.isColorLevel())
                {
                  QLog.e("StickerRecBarAdapter", 2, "onClick input == null");
                  i = 0;
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.e("StickerRecBarAdapter", 2, "onClick:URLDrawable status != successed");
              }
            }
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter
 * JD-Core Version:    0.7.0.1
 */