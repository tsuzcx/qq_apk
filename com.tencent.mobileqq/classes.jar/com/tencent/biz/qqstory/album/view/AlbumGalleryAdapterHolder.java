package com.tencent.biz.qqstory.album.view;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.StoryAlbumConfig;
import com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AlbumGalleryAdapterHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private StoryAlbum jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum;
  private AlbumGalleryAdapterHolder.OnHolderItemClickListener jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder$OnHolderItemClickListener;
  public AlbumImageView a;
  public RoundCornerLayout a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private EmptyDrawable jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  private String jdField_a_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20181016/dde952e69c2c48c6a0536954c0a96cb5.mp4";
  private List<StoryAlbum.PicInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  public int b;
  public View b;
  public ImageView b;
  public LinearLayout b;
  public TextView b;
  public AlbumImageView b;
  private String b;
  private int c;
  public ImageView c;
  public TextView c;
  private int d;
  public ImageView d;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public AlbumGalleryAdapterHolder(Activity paramActivity, View paramView, int paramInt1, int paramInt2, AlbumGalleryAdapterHolder.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.jdField_b_of_type_JavaLangString = "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder$OnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130846745);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView = ((AlbumImageView)paramView.findViewById(2131362599));
    this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView = ((AlbumImageView)paramView.findViewById(2131362612));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362678));
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout = ((RoundCornerLayout)paramView.findViewById(2131362602));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362680));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362675));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362614));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362656));
    this.e = ((TextView)paramView.findViewById(2131362679));
    this.f = ((TextView)paramView.findViewById(2131362660));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362608));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131362604);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362613));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362650));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364516));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364517));
    this.g = ((TextView)paramView.findViewById(2131364518));
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setRadius(11.0F);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setWillNotDraw(false);
    paramActivity = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.getLayoutParams();
    paramActivity.width = paramInt1;
    paramActivity.height = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setLayoutParams(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = new AlbumGalleryAdapterHolder.HolderMsgUIHandler(this, Looper.getMainLooper());
    paramActivity = (StoryScanManager)SuperManager.a(30);
    if (!TextUtils.isEmpty(paramActivity.a().a())) {
      this.jdField_a_of_type_JavaLangString = paramActivity.a().a();
    }
    if (!TextUtils.isEmpty(paramActivity.a().b())) {
      this.jdField_b_of_type_JavaLangString = paramActivity.a().b();
    }
  }
  
  private int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum != null) {
      i = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.e;
    }
    return i;
  }
  
  private int a(List<StoryAlbum.PicInfo> paramList, int paramInt)
  {
    int i;
    if ((paramList == null) || (paramList.size() == 0))
    {
      i = -1;
      return i;
    }
    int j = Math.max(0, paramInt);
    for (;;)
    {
      if (j >= paramList.size()) {
        break label74;
      }
      i = j;
      if (new File(((StoryAlbum.PicInfo)paramList.get(j)).jdField_a_of_type_JavaLangString).exists()) {
        break;
      }
      j += 1;
    }
    label74:
    j = 0;
    for (;;)
    {
      if ((j >= paramList.size()) || (j >= paramInt)) {
        break label133;
      }
      i = j;
      if (new File(((StoryAlbum.PicInfo)paramList.get(j)).jdField_a_of_type_JavaLangString).exists()) {
        break;
      }
      j += 1;
    }
    label133:
    return -1;
  }
  
  /* Error */
  private Drawable a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 278	java/io/FileInputStream
    //   6: dup
    //   7: new 253	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 263	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 281	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokestatic 287	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_1
    //   28: aload_2
    //   29: ifnull +9 -> 38
    //   32: aload_2
    //   33: invokevirtual 290	java/io/FileInputStream:close	()V
    //   36: aload_3
    //   37: astore_1
    //   38: aload 4
    //   40: astore_2
    //   41: aload_1
    //   42: ifnull +12 -> 54
    //   45: new 292	android/graphics/drawable/BitmapDrawable
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 295	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   53: astore_2
    //   54: aload_2
    //   55: areturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: ldc_w 297
    //   64: ldc_w 299
    //   67: aload_3
    //   68: invokestatic 304	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_2
    //   72: ifnull +49 -> 121
    //   75: aload_2
    //   76: invokevirtual 290	java/io/FileInputStream:close	()V
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -43 -> 38
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_1
    //   87: goto -49 -> 38
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 290	java/io/FileInputStream:close	()V
    //   101: aload_2
    //   102: athrow
    //   103: astore_1
    //   104: aload_3
    //   105: astore_1
    //   106: goto -68 -> 38
    //   109: astore_1
    //   110: goto -9 -> 101
    //   113: astore_2
    //   114: goto -21 -> 93
    //   117: astore_3
    //   118: goto -59 -> 59
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -85 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	AlbumGalleryAdapterHolder
    //   0	126	1	paramString	String
    //   18	58	2	localObject1	Object
    //   90	12	2	localObject2	Object
    //   113	1	2	localObject3	Object
    //   25	12	3	localBitmap	android.graphics.Bitmap
    //   56	49	3	localThrowable1	Throwable
    //   117	1	3	localThrowable2	Throwable
    //   1	38	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	56	java/lang/Throwable
    //   75	79	84	java/io/IOException
    //   3	19	90	finally
    //   32	36	103	java/io/IOException
    //   97	101	109	java/io/IOException
    //   21	26	113	finally
    //   61	71	113	finally
    //   21	26	117	java/lang/Throwable
  }
  
  private URLDrawable a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, AlbumGalleryAdapterHolder paramAlbumGalleryAdapterHolder)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    paramAlbumGalleryAdapterHolder = new AlbumGalleryAdapterHolder.QQLiveListener(paramAlbumGalleryAdapterHolder);
    localQQLiveDrawableParams.mPreviewWidth = paramInt1;
    localQQLiveDrawableParams.mPreviewHeight = paramInt2;
    localQQLiveDrawableParams.mDataSource = paramString1;
    localQQLiveDrawableParams.mLoopback = true;
    localQQLiveDrawableParams.mMute = false;
    localQQLiveDrawableParams.mCoverUrl = paramString2;
    localQQLiveDrawableParams.mCoverLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    if (!paramBoolean) {
      localQQLiveDrawableParams.mDataSourceType = 1;
    }
    for (localQQLiveDrawableParams.mPlayType = 0;; localQQLiveDrawableParams.mPlayType = 2)
    {
      localQQLiveDrawableParams.mListener = paramAlbumGalleryAdapterHolder;
      localQQLiveDrawableParams.mDownloadListener = paramAlbumGalleryAdapterHolder;
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      paramString2.mExtraInfo = localQQLiveDrawableParams;
      paramString2.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      paramString2.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      return URLDrawable.getDrawable(a(paramString1), paramString2);
      localQQLiveDrawableParams.mDataSourceType = 3;
    }
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=").append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.e = paramInt;
    }
  }
  
  private void a(HashSet<View> paramHashSet)
  {
    if (paramHashSet.contains(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
      if (!paramHashSet.contains(this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView)) {
        break label298;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
      label38:
      if (!paramHashSet.contains(this.jdField_a_of_type_AndroidWidgetTextView)) {
        break label310;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label57:
      if (!paramHashSet.contains(this.jdField_b_of_type_AndroidWidgetTextView)) {
        break label322;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label76:
      if (!paramHashSet.contains(this.jdField_c_of_type_AndroidWidgetTextView)) {
        break label334;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      label95:
      if (!paramHashSet.contains(this.jdField_d_of_type_AndroidWidgetTextView)) {
        break label346;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label114:
      if (!paramHashSet.contains(this.e)) {
        break label358;
      }
      this.e.setVisibility(0);
      label133:
      if (!paramHashSet.contains(this.f)) {
        break label370;
      }
      this.f.setVisibility(0);
      label152:
      if (!paramHashSet.contains(this.jdField_a_of_type_AndroidWidgetImageView)) {
        break label382;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label171:
      if (!paramHashSet.contains(this.jdField_b_of_type_AndroidViewView)) {
        break label394;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label190:
      if (!paramHashSet.contains(this.jdField_b_of_type_AndroidWidgetImageView)) {
        break label406;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      label209:
      if (!paramHashSet.contains(this.jdField_b_of_type_AndroidWidgetLinearLayout)) {
        break label418;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label228:
      if (!paramHashSet.contains(this.jdField_d_of_type_AndroidWidgetImageView)) {
        break label430;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      label247:
      if (!paramHashSet.contains(this.g)) {
        break label442;
      }
      this.g.setVisibility(0);
    }
    for (;;)
    {
      if (!paramHashSet.contains(this.jdField_c_of_type_AndroidWidgetImageView)) {
        break label454;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
      break;
      label298:
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
      break label38;
      label310:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label57;
      label322:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label76;
      label334:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label95;
      label346:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label114;
      label358:
      this.e.setVisibility(8);
      break label133;
      label370:
      this.f.setVisibility(8);
      break label152;
      label382:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label171;
      label394:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label190;
      label406:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label209;
      label418:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label228;
      label430:
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      break label247;
      label442:
      this.g.setVisibility(8);
    }
    label454:
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(List<String> paramList)
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayCenterImg :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum });
    this.jdField_c_of_type_Int = 3;
    if (paramList.size() == 0)
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayCenterImg error , no pic list");
      return;
    }
    AnimationDrawable localAnimationDrawable;
    try
    {
      localAnimationDrawable = new AnimationDrawable();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Drawable localDrawable = a((String)paramList.next());
        if (localDrawable != null) {
          localAnimationDrawable.addFrame(localDrawable, 40);
        }
      }
      localAnimationDrawable.setOneShot(false);
    }
    catch (Throwable paramList)
    {
      SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayCenterImg error , %s", paramList);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
    localAnimationDrawable.start();
  }
  
  private void d()
  {
    Object localObject = new HashSet();
    ((HashSet)localObject).add(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView);
    ((HashSet)localObject).add(this.jdField_a_of_type_AndroidWidgetTextView);
    ((HashSet)localObject).add(this.jdField_c_of_type_AndroidWidgetTextView);
    ((HashSet)localObject).add(this.e);
    ((HashSet)localObject).add(this.jdField_b_of_type_AndroidWidgetImageView);
    ((HashSet)localObject).add(this.f);
    ((HashSet)localObject).add(this.jdField_b_of_type_AndroidViewView);
    ((HashSet)localObject).add(this.jdField_c_of_type_AndroidWidgetImageView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a() == 0) {
      ((HashSet)localObject).add(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getAnimation() == null))
    {
      ((HashSet)localObject).add(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      ((HashSet)localObject).add(this.jdField_d_of_type_AndroidWidgetImageView);
      ((HashSet)localObject).add(this.g);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setStartOffset(500L);
      localAlphaAnimation.setAnimationListener(new AlbumGalleryAdapterHolder.1(this));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(localAlphaAnimation);
    }
    a((HashSet)localObject);
    localObject = this.jdField_a_of_type_JavaUtilList;
    int i = a((List)localObject, 0);
    if (i < 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a(((List)localObject).size()))) {
        break label364;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131700248), new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_b_of_type_JavaLangString, Integer.valueOf(((List)localObject).size()) }));
    }
    for (;;)
    {
      this.f.setText(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.b()));
      this.e.setText(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a());
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((StoryAlbum.PicInfo)((List)localObject).get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
      label364:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a(((List)localObject).size()));
    }
  }
  
  private void e()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    a(localHashSet);
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView, null, this.jdField_b_of_type_JavaLangString, false, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700254));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700256));
  }
  
  private void f()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846747);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846745);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700263));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700246));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700264));
    this.g.setText(HardCodeUtil.a(2131700241));
  }
  
  private void g()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846750);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846745);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700257));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700261));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700267));
    this.g.setText(HardCodeUtil.a(2131700239));
  }
  
  private void h()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846746);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846745);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700265));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700266));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700262));
    this.g.setText(HardCodeUtil.a(2131700242));
  }
  
  private void i()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_a_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_c_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetTextView);
    localHashSet.add(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    localHashSet.add(this.jdField_d_of_type_AndroidWidgetImageView);
    localHashSet.add(this.g);
    a(localHashSet);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846748);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130846745);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700252));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700247));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700258));
    this.g.setText(HardCodeUtil.a(2131700260));
  }
  
  private void j()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayLoop :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum });
    if ((this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum == null) || (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a()))
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayLoop error ,album not exist");
      this.jdField_c_of_type_Int = 0;
      return;
    }
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilList.size() <= 1)
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayLoop error ,get pick count not enough ,size = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      this.jdField_c_of_type_Int = 0;
      return;
    }
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayLoop success ,get pick count = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
  }
  
  private void k()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayLoop");
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.clearAnimation();
    this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.clearAnimation();
    this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a();
      if (((List)localObject).size() <= 0) {
        break label111;
      }
    }
    label111:
    for (Object localObject = ((StoryAlbum.PicInfo)((List)localObject).get(0)).jdField_a_of_type_JavaLangString;; localObject = "")
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable((String)localObject, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
  }
  
  private void l()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "startPlayMp4 :%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum });
    QQLiveImage.onForeground(this.jdField_a_of_type_AndroidAppActivity);
    QQLiveImage.resumeAll(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      m();
    }
    this.jdField_c_of_type_Int = 2;
    this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    localURLDrawableOptions.mRetryCount = 1;
    this.jdField_a_of_type_ComTencentImageURLDrawable = a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, false, this);
    this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setURLDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  private void m()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayMp4");
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))
      {
        QQLiveDrawable localQQLiveDrawable = (QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        localQQLiveDrawable.release();
        localQQLiveDrawable.setOnStateListener(null);
        localQQLiveDrawable.setParams(null);
        SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayMp4 suc");
      }
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setURLDrawable(null);
      this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
  
  private void n()
  {
    if ((this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView != null) && (this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).release();
    }
  }
  
  private void o()
  {
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayCenterImg");
    this.jdField_c_of_type_Int = 0;
    Drawable localDrawable = this.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable))) {
      ((AnimationDrawable)localDrawable).stop();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum != null) {
      a(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
    }
  }
  
  public void a(@NonNull StoryAlbum paramStoryAlbum)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.equals(paramStoryAlbum)) && (this.jdField_c_of_type_Int != 0)) {
      c();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum = paramStoryAlbum;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a();
    paramStoryAlbum = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)((Iterator)localObject).next();
      if (localPicInfo.a()) {
        paramStoryAlbum.add(localPicInfo);
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramStoryAlbum;
    if (this.jdField_c_of_type_Int == 0)
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a()) {
        break label185;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 1) {
        e();
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 3)
    {
      f();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 2)
    {
      g();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 5)
    {
      i();
      return;
    }
    h();
    return;
    label185:
    d();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum == null) {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "data empty , startPlay error!");
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_Int != 0);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 1)
      {
        l();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int != 2);
    a(StoryAlbumResourceDownloader.a().a(StoryAlbumResourceDownloader.jdField_a_of_type_Int));
    return;
    j();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum == null) {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "data empty , stopPlay error!");
    }
    while (this.jdField_c_of_type_Int == 0) {
      return;
    }
    SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stop play :%s", this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.a()) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 1) {
        m();
      }
    }
    for (;;)
    {
      a();
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.jdField_d_of_type_Int == 2)
      {
        o();
        continue;
        k();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (StoryConfigManager)SuperManager.a(10);
      int i = ((Integer)((StoryConfigManager)localObject).b("key_album_delete_dialog_show_count", Integer.valueOf(0))).intValue();
      if (i < 3)
      {
        ((StoryConfigManager)localObject).b("key_album_delete_dialog_show_count", Integer.valueOf(i + 1));
        localObject = new AlbumGalleryAdapterHolder.2(this);
        localObject = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, 2131559084, HardCodeUtil.a(2131700243), null, HardCodeUtil.a(2131700250), HardCodeUtil.a(2131700253), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
        ((QQCustomDialog)localObject).setCancelable(true);
        ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((QQCustomDialog)localObject).show();
      }
      for (;;)
      {
        StoryReportor.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum.d()), "1" });
        break;
        if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder$OnHolderItemClickListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder$OnHolderItemClickListener.b(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum);
        }
      }
      if (!UIUtils.b()) {
        PressScaleAnimDelegate.a(this.jdField_a_of_type_AndroidViewView, 300L, new AlbumGalleryAdapterHolder.3(this), new float[] { 1.0F, 0.95F, 1.0F });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder
 * JD-Core Version:    0.7.0.1
 */