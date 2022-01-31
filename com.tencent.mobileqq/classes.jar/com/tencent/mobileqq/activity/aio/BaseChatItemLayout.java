package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.Sticker;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerDoubleClickListener;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopMemberGlobalLevelUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;
import upf;

public class BaseChatItemLayout
  extends ChatItemAnimLayout
{
  public static int A;
  public static final float a;
  public static final int a;
  public static CompoundButton.OnCheckedChangeListener a;
  public static BaseChatItemLayout.OnChatMessageCheckedChangeListener a;
  public static boolean a;
  public static final float b;
  public static final int b;
  public static final float c;
  public static int c;
  @Deprecated
  public static final float d;
  public static int d;
  public static int e;
  public static int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  public static final int r;
  public static final int s;
  public static final int t;
  public static final int u;
  public static final int v;
  public static int w;
  public static final int x;
  public static int y;
  public static int z;
  int B = 0;
  int C;
  private int F;
  private int G;
  private int H;
  private int I;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  View jdField_a_of_type_AndroidViewView;
  public CheckBox a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ProgressBar a;
  public TextView a;
  public URLImageView a;
  public DynamicAvatarView a;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public EmojiStickerManager.StickerDoubleClickListener a;
  TroopRobotNextTipsView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView;
  public ArrayList a;
  public ImageView b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private boolean jdField_b_of_type_Boolean;
  public ImageView c;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  public TextView c;
  private boolean jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
  public ImageView d;
  public TextView d;
  private boolean d;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  TextView f;
  TextView g;
  private TextView h;
  private TextView i;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    jdField_d_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131558422);
    jdField_b_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131558407);
    jdField_c_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131558422);
    jdField_g_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131558599);
    jdField_h_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131558600);
    jdField_i_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131558601);
    j = localBaseApplication.getResources().getDimensionPixelSize(2131558602);
    k = localBaseApplication.getResources().getDimensionPixelSize(2131558603);
    l = localBaseApplication.getResources().getDimensionPixelSize(2131558606);
    m = localBaseApplication.getResources().getDimensionPixelSize(2131558607);
    n = localBaseApplication.getResources().getDimensionPixelSize(2131558608);
    o = localBaseApplication.getResources().getDimensionPixelSize(2131558609);
    r = localBaseApplication.getResources().getDimensionPixelSize(2131558618);
    q = localBaseApplication.getResources().getDimensionPixelSize(2131558617);
    p = localBaseApplication.getResources().getDimensionPixelSize(2131558605);
    jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
    jdField_c_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    jdField_d_of_type_Int = (int)(jdField_c_of_type_Int - 118.0F * jdField_d_of_type_Float);
    jdField_e_of_type_Int = jdField_d_of_type_Int - jdField_i_of_type_Int - j;
    jdField_f_of_type_Int = jdField_e_of_type_Int - r * 2;
    s = localBaseApplication.getResources().getDimensionPixelSize(2131558613);
    t = localBaseApplication.getResources().getDimensionPixelSize(2131558614);
    u = localBaseApplication.getResources().getDimensionPixelSize(2131558612);
    v = localBaseApplication.getResources().getDimensionPixelSize(2131558624);
    w = localBaseApplication.getResources().getDimensionPixelSize(2131558628);
    x = jdField_c_of_type_Int - s - t - localBaseApplication.getResources().getDimensionPixelSize(2131558652) * 2;
    y = localBaseApplication.getResources().getDimensionPixelSize(2131558625);
    z = localBaseApplication.getResources().getDimensionPixelSize(2131558626);
    A = localBaseApplication.getResources().getDimensionPixelSize(2131558627);
    jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new upf();
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
  }
  
  private SpannableStringBuilder a(CharSequence paramCharSequence1, TextView paramTextView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CharSequence paramCharSequence2, ColorStateList paramColorStateList, boolean paramBoolean4)
  {
    if ((paramCharSequence1 == null) || ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)))
    {
      paramTextView = null;
      return paramTextView;
    }
    paramColorStateList = paramTextView.getEllipsize();
    if (paramColorStateList != null)
    {
      if (!paramBoolean1) {
        break label278;
      }
      paramInt = (int)(paramInt - Math.ceil(13.0F * jdField_d_of_type_Float));
    }
    label268:
    label278:
    for (;;)
    {
      int i1 = paramInt;
      if (paramBoolean2) {
        i1 = (int)(paramInt - Math.ceil(15.0F * jdField_d_of_type_Float));
      }
      if (paramBoolean3) {
        i1 = AIOUtils.a(136.0F, getContext().getResources());
      }
      paramInt = i1;
      if (i1 < 0) {
        paramInt = 0;
      }
      paramCharSequence1 = new SpannableStringBuilder(TextUtils.ellipsize(paramCharSequence1, paramTextView.getPaint(), paramInt, paramColorStateList));
      label127:
      if (paramBoolean1)
      {
        paramTextView = getResources().getDrawable(2130844267);
        paramTextView.setBounds(0, 0, (int)(13.0F * jdField_d_of_type_Float), (int)(13.0F * jdField_d_of_type_Float));
        paramTextView = new ImageSpan(paramTextView, 0);
        paramColorStateList = new SpannableString(" ");
        paramColorStateList.setSpan(paramTextView, 0, 1, 33);
        if ((paramCharSequence1.length() <= 1) || (paramCharSequence1.charAt(paramCharSequence1.length() - 1) != ':')) {
          break label268;
        }
        paramCharSequence1.insert(paramCharSequence1.length() - 1, paramColorStateList);
      }
      for (;;)
      {
        paramTextView = paramCharSequence1;
        if (!paramBoolean3) {
          break;
        }
        paramTextView = paramCharSequence1;
        if (TextUtils.isEmpty(paramCharSequence2)) {
          break;
        }
        paramCharSequence1.append(paramCharSequence2);
        return paramCharSequence1;
        paramCharSequence1 = new SpannableStringBuilder(paramCharSequence1);
        break label127;
        paramCharSequence1.append(paramColorStateList);
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = findViewById(2131361877);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)((View)localObject).getTag(2131362294));
      this.F = ((View)localObject).getLeft();
      this.G = ((View)localObject).getMeasuredWidth();
      this.H = ((View)localObject).getTop();
      this.I = ((View)localObject).getMeasuredHeight();
    }
    int i2;
    int i1;
    int i3;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i2 = 0;
      i1 = 0;
      if (i2 <= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        label151:
        int i4;
        boolean bool;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden))
        {
          if (localSticker.jdField_a_of_type_Int + this.F + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2)
          {
            i3 = -400;
            localSticker.jdField_e_of_type_Int = i3;
            localSticker.jdField_f_of_type_Int = 0;
          }
        }
        else
        {
          i4 = paramCanvas.getSaveCount();
          paramCanvas.save();
          i3 = localSticker.jdField_a_of_type_Int + this.F;
          int i5 = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.jdField_c_of_type_Int);
          int i6 = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.jdField_d_of_type_Int);
          paramCanvas.translate(localSticker.jdField_e_of_type_Int + i3 - i5 / 2, localSticker.jdField_b_of_type_Int - i6 / 2);
          paramCanvas.rotate((float)localSticker.jdField_a_of_type_Double, localSticker.jdField_c_of_type_Int * localSticker.jdField_a_of_type_Float / 2.0F, localSticker.jdField_d_of_type_Int * localSticker.jdField_a_of_type_Float / 2.0F);
          localSticker.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(localSticker.jdField_f_of_type_Int);
          localSticker.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)(localSticker.jdField_c_of_type_Int * localSticker.jdField_a_of_type_Float), (int)(localSticker.jdField_d_of_type_Int * localSticker.jdField_a_of_type_Float));
          localSticker.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restoreToCount(i4);
          if ((!localSticker.jdField_a_of_type_Boolean) && ((!(localSticker.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) || (((URLDrawable)localSticker.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getStatus() == 1)))
          {
            if ((localSticker.jdField_c_of_type_Int - localSticker.jdField_g_of_type_Int >= 0) && (localSticker.jdField_d_of_type_Int - localSticker.jdField_h_of_type_Int >= 0)) {
              break label677;
            }
            bool = true;
            label417:
            localSticker.jdField_a_of_type_Boolean = bool;
            if (localSticker.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo != null) {
              localSticker.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo.isShown = localSticker.jdField_a_of_type_Boolean;
            }
            if (!localSticker.jdField_a_of_type_Boolean)
            {
              i4 = paramCanvas.getSaveCount();
              paramCanvas.save();
              paramCanvas.translate(localSticker.jdField_e_of_type_Int + i3 - localSticker.jdField_c_of_type_Int / 2 + localSticker.jdField_g_of_type_Int, localSticker.jdField_b_of_type_Int - localSticker.jdField_d_of_type_Int / 2 + localSticker.jdField_h_of_type_Int);
              paramCanvas.clipRect(0, 0, localSticker.jdField_c_of_type_Int, localSticker.jdField_d_of_type_Int);
              if (localSticker.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
                break label683;
              }
            }
          }
        }
        label677:
        label683:
        for (localObject = EmojiStickerManager.a().a(getContext()).mutate();; localObject = localSticker.jdField_b_of_type_AndroidGraphicsDrawableDrawable)
        {
          ((Drawable)localObject).setBounds(0, 0, localSticker.jdField_c_of_type_Int, localSticker.jdField_d_of_type_Int);
          ((Drawable)localObject).draw(paramCanvas);
          paramCanvas.restoreToCount(i4);
          localSticker.jdField_g_of_type_Int += EmojiStickerManager.j;
          localSticker.jdField_h_of_type_Int += EmojiStickerManager.j;
          localSticker.jdField_a_of_type_Float -= EmojiStickerManager.jdField_a_of_type_Float;
          if (localSticker.jdField_a_of_type_Float < 1.0F) {
            localSticker.jdField_a_of_type_Float = 1.0F;
          }
          if (localSticker.jdField_a_of_type_Boolean) {
            localSticker.jdField_a_of_type_Float = 1.0F;
          }
          if (localSticker.jdField_a_of_type_Boolean) {
            break label808;
          }
          i1 = 1;
          i2 += 1;
          break;
          i3 = 400;
          break label151;
          bool = false;
          break label417;
        }
      }
      c();
    }
    for (;;)
    {
      if ((EmojiStickerManager.jdField_b_of_type_Boolean) || ((!EmojiStickerManager.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Boolean)))
      {
        i3 = paramCanvas.getSaveCount();
        paramCanvas.clipRect(this.F, this.H, this.F + this.G, this.H + this.I);
        if (!this.jdField_b_of_type_Boolean) {
          break label798;
        }
      }
      label798:
      for (i2 = Color.parseColor("#19000000");; i2 = Color.parseColor("#00000000"))
      {
        paramCanvas.drawColor(i2);
        paramCanvas.restoreToCount(i3);
        if (!EmojiStickerManager.jdField_b_of_type_Boolean) {
          this.jdField_b_of_type_Boolean = false;
        }
        if (i1 != 0) {
          invalidate();
        }
        return;
      }
      label808:
      break;
      i1 = 0;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
        int i2 = localSticker.jdField_a_of_type_Int;
        int i3 = this.F;
        int i4 = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.jdField_c_of_type_Int);
        int i1 = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.jdField_d_of_type_Int);
        i2 = i2 + i3 + localSticker.jdField_e_of_type_Int - i4 / 2;
        i1 = localSticker.jdField_b_of_type_Int - i1 / 2;
        if ((paramFloat1 > i2) && (paramFloat1 < i2 + localSticker.jdField_a_of_type_Float * localSticker.jdField_c_of_type_Int) && (paramFloat2 > i1))
        {
          float f1 = i1;
          float f2 = localSticker.jdField_a_of_type_Float;
          if (paramFloat2 < localSticker.jdField_d_of_type_Int * f2 + f1) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime() > 200L) {}
    int i1;
    int i2;
    do
    {
      return false;
      i1 = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
      i2 = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    } while (i1 * i1 + i2 * i2 >= 10000);
    return true;
  }
  
  private void b(int paramInt)
  {
    if (this.C != paramInt)
    {
      this.C = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams()).addRule(3, this.C);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams()).addRule(3, this.C);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.C);
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.C);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.C);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.C);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)))
      {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.C);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setTopId mTopId = " + this.C);
        }
      }
    }
  }
  
  private void c()
  {
    boolean bool;
    EmojiStickerManager.Sticker localSticker;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        localSticker = (EmojiStickerManager.Sticker)localIterator.next();
        if (localSticker.jdField_a_of_type_Int + this.F + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(localSticker.jdField_e_of_type_Int) > 200)
          {
            localSticker.jdField_e_of_type_Int -= EmojiStickerManager.jdField_i_of_type_Int;
            localSticker.jdField_f_of_type_Int -= Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
            localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
            label138:
            if (localSticker.jdField_e_of_type_Int > 0)
            {
              localSticker.jdField_e_of_type_Int = 0;
              if (EmojiStickerManager.jdField_a_of_type_AndroidViewView == null) {
                localSticker.jdField_f_of_type_Int = 255;
              }
              this.jdField_d_of_type_Boolean = false;
              bool = false;
            }
            label170:
            if (localSticker.jdField_e_of_type_Int < -400)
            {
              localSticker.jdField_e_of_type_Int = -400;
              localSticker.jdField_f_of_type_Int = 0;
              this.jdField_d_of_type_Boolean = false;
              bool = true;
            }
            if (localSticker.jdField_e_of_type_Int <= 400) {
              break label446;
            }
            localSticker.jdField_e_of_type_Int = 400;
            localSticker.jdField_f_of_type_Int = 0;
            this.jdField_d_of_type_Boolean = false;
            bool = true;
          }
        }
      }
    }
    label424:
    label446:
    for (;;)
    {
      break;
      localSticker.jdField_f_of_type_Int += Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
      localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
      localSticker.jdField_e_of_type_Int += EmojiStickerManager.jdField_i_of_type_Int;
      break label138;
      if (Math.abs(localSticker.jdField_e_of_type_Int) < 200)
      {
        localSticker.jdField_f_of_type_Int += Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
        localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
      }
      for (localSticker.jdField_e_of_type_Int -= EmojiStickerManager.jdField_i_of_type_Int;; localSticker.jdField_e_of_type_Int += EmojiStickerManager.jdField_i_of_type_Int)
      {
        if (localSticker.jdField_e_of_type_Int >= 0) {
          break label424;
        }
        localSticker.jdField_e_of_type_Int = 0;
        if (EmojiStickerManager.jdField_a_of_type_AndroidViewView == null) {
          localSticker.jdField_f_of_type_Int = 255;
        }
        this.jdField_d_of_type_Boolean = false;
        bool = false;
        break;
        localSticker.jdField_f_of_type_Int -= Math.abs(EmojiStickerManager.jdField_i_of_type_Int / 2);
        localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
      }
      break label170;
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden = bool;
      }
      invalidate();
      return;
    }
  }
  
  public int a()
  {
    return this.C;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)localIterator.next();
        localSticker.jdField_b_of_type_Int += paramInt;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i1;
      label45:
      EmojiStickerManager.Sticker localSticker;
      int i2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden))
      {
        i1 = 1;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label419;
        }
        localSticker = (EmojiStickerManager.Sticker)localIterator.next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (i1 != 0))
        {
          if (localSticker.jdField_a_of_type_Int + this.F + localSticker.jdField_c_of_type_Int / 2 >= getMeasuredWidth() / 2) {
            break label267;
          }
          i2 = -400;
          label110:
          localSticker.jdField_e_of_type_Int = i2;
          localSticker.jdField_f_of_type_Int = 0;
        }
        if ((paramInt2 != EmojiStickerManager.jdField_h_of_type_Int) || (localSticker.jdField_e_of_type_Int != 0))
        {
          if (paramInt2 != EmojiStickerManager.jdField_g_of_type_Int) {
            break label290;
          }
          if (localSticker.jdField_a_of_type_Int + this.F + localSticker.jdField_c_of_type_Int / 2 >= getMeasuredWidth() / 2) {
            break label275;
          }
          localSticker.jdField_e_of_type_Int -= paramInt1;
          localSticker.jdField_f_of_type_Int -= Math.abs(paramInt1 / 2);
          localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
        }
      }
      label267:
      label275:
      label290:
      while (paramInt2 != EmojiStickerManager.jdField_h_of_type_Int) {
        for (;;)
        {
          if (localSticker.jdField_e_of_type_Int < -400) {
            localSticker.jdField_e_of_type_Int = -400;
          }
          if (localSticker.jdField_e_of_type_Int <= 400) {
            break label45;
          }
          localSticker.jdField_e_of_type_Int = 400;
          break label45;
          i1 = 0;
          break;
          i2 = 400;
          break label110;
          localSticker.jdField_e_of_type_Int += paramInt1;
        }
      }
      if (localSticker.jdField_a_of_type_Int + this.F + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2)
      {
        localSticker.jdField_e_of_type_Int += paramInt1;
        if (localSticker.jdField_e_of_type_Int > 0) {
          localSticker.jdField_e_of_type_Int = 0;
        }
      }
      for (;;)
      {
        localSticker.jdField_f_of_type_Int += Math.abs(paramInt1 / 2);
        localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
        break;
        localSticker.jdField_e_of_type_Int -= paramInt1;
        if (localSticker.jdField_e_of_type_Int < 0) {
          localSticker.jdField_e_of_type_Int = 0;
        }
      }
      label419:
      if ((i1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.stickerHidden = false;
      }
      invalidate();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setId(2131361877);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_d_of_type_AndroidWidgetTextView.setId(2131361868);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(getContext(), 18.0F));
        paramQQAppInterface.topMargin = DisplayUtil.a(getContext(), -3.0F);
        paramQQAppInterface.addRule(6, 2131361870);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131361870);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_d_of_type_AndroidWidgetTextView, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramBoolean2)
      {
        paramQQAppInterface.rightMargin = AIOUtils.a(2.0F, getContext().getResources());
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(0, 2131361871);
        paramQQAppInterface.addRule(1, 0);
        paramQQAppInterface = TroopMemberGlobalLevelUtils.a(paramInt);
        if (paramQQAppInterface == null) {
          break label505;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        i1 = AIOUtils.a(16.0F, getContext().getResources());
        paramQQAppInterface.setBounds(0, 0, i1, i1);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(paramQQAppInterface, null, null, null);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription("魅力等级" + paramInt);
      }
    }
    label503:
    label505:
    while ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        int i1;
        return;
        if (a())
        {
          paramQQAppInterface.rightMargin = AIOUtils.a(2.0F, getContext().getResources());
          if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
          {
            paramQQAppInterface.addRule(0, 2131361870);
            paramQQAppInterface.addRule(1, 0);
            paramQQAppInterface.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
            paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
            paramQQAppInterface.addRule(0, 2131361868);
            paramQQAppInterface.addRule(1, 0);
          }
          else
          {
            paramQQAppInterface.leftMargin = 0;
            paramQQAppInterface.addRule(0, 2131361870);
            paramQQAppInterface.addRule(1, 0);
          }
        }
        else
        {
          if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
          {
            paramQQAppInterface.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
            paramQQAppInterface.rightMargin = 0;
            paramQQAppInterface.addRule(1, 2131361867);
            paramQQAppInterface.addRule(0, 0);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
              break label503;
            }
            paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
            paramQQAppInterface.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
            paramQQAppInterface.addRule(1, 2131361868);
            break;
            paramQQAppInterface.leftMargin = A;
            paramQQAppInterface.rightMargin = 0;
            paramQQAppInterface.addRule(1, 2131361863);
            paramQQAppInterface.addRule(0, 0);
          }
          continue;
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, View.OnClickListener paramOnClickListener, ChatMessage paramChatMessage)
  {
    if (!paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      return;
    }
    Object localObject = getContext();
    RelativeLayout.LayoutParams localLayoutParams;
    GoldMsgQueueView localGoldMsgQueueView;
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout((Context)localObject);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setId(2131362403);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setGravity(16);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130844164);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131361877);
      paramOnClickListener = new TextView((Context)localObject);
      paramOnClickListener.setId(2131362400);
      paramOnClickListener.setSingleLine();
      paramOnClickListener.setEllipsize(TextUtils.TruncateAt.END);
      paramOnClickListener.setTextSize(2, 14.0F);
      paramOnClickListener.setMinHeight(GoldMsgChatHelper.jdField_g_of_type_Int);
      paramOnClickListener.setGravity(16);
      paramOnClickListener.setTextColor(GoldMsgChatHelper.jdField_i_of_type_Int);
      paramOnClickListener.setCompoundDrawablePadding(GoldMsgChatHelper.jdField_b_of_type_Int);
      localGoldMsgQueueView = new GoldMsgQueueView((Context)localObject);
      localGoldMsgQueueView.setId(2131362404);
      localObject = new TextView((Context)localObject);
      ((TextView)localObject).setId(2131362405);
      ((TextView)localObject).setSingleLine();
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setTextSize(2, 14.0F);
      ((TextView)localObject).setTextColor(GoldMsgChatHelper.j);
      ((TextView)localObject).setText("暂无人领取");
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams1.setMargins(0, 0, GoldMsgChatHelper.jdField_c_of_type_Int, 0);
      paramOnClickListener.setLayoutParams(localLayoutParams1);
      localGoldMsgQueueView.setLayoutParams(new LinearLayout.LayoutParams(GoldMsgChatHelper.jdField_g_of_type_Int, GoldMsgChatHelper.jdField_g_of_type_Int));
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(paramOnClickListener);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localGoldMsgQueueView);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      paramOnClickListener.setCompoundDrawablePadding(GoldMsgChatHelper.jdField_b_of_type_Int);
      addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      GoldMsgChatHelper.a(paramQQAppInterface, paramOnClickListener, localGoldMsgQueueView, (TextView)localObject, paramChatMessage);
      if (!paramChatMessage.isSend()) {
        break label506;
      }
      localLayoutParams.rightMargin = jdField_i_of_type_Int;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.addRule(7, 2131361877);
      localLayoutParams.addRule(5, 0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setPadding(GoldMsgChatHelper.jdField_d_of_type_Int, GoldMsgChatHelper.jdField_e_of_type_Int, GoldMsgChatHelper.jdField_d_of_type_Int, GoldMsgChatHelper.jdField_e_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setTag(paramChatMessage);
      return;
      paramOnClickListener = (TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131362400);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localGoldMsgQueueView = (GoldMsgQueueView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131362404);
      localObject = (TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131362405);
      break;
      label506:
      localLayoutParams.leftMargin = jdField_i_of_type_Int;
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(5, 2131361877);
      localLayoutParams.addRule(7, 0);
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_e_of_type_AndroidWidgetTextView.setId(2131361868);
        this.jdField_e_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_e_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources()));
        this.jdField_e_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(4.0F, this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources()), 0, AIOUtils.a(4.0F, this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources()), 0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramQQAppInterface = this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources().getDrawable(2130842873);
        i1 = Color.parseColor("#12B7F5");
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(TroopUtils.a(this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources(), i1, paramQQAppInterface));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
        paramQQAppInterface.bottomMargin = DisplayUtil.a(getContext(), 1.0F);
        paramQQAppInterface.topMargin = DisplayUtil.a(getContext(), 1.0F);
        paramQQAppInterface.addRule(6, 2131361870);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131361870);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_e_of_type_AndroidWidgetTextView, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
      if (a())
      {
        paramQQAppInterface.rightMargin = AIOUtils.a(2.0F, getContext().getResources());
        if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.addRule(0, 2131361870);
          paramQQAppInterface.addRule(1, 0);
          paramQQAppInterface.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams();
          paramQQAppInterface.addRule(0, 2131361868);
          paramQQAppInterface.addRule(1, 0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
    }
    while ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        int i1;
        return;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(0, 2131361870);
        paramQQAppInterface.addRule(1, 0);
        continue;
        if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131361866);
          paramQQAppInterface.addRule(0, 0);
        }
        else
        {
          paramQQAppInterface.leftMargin = A;
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131361863);
          paramQQAppInterface.addRule(0, 0);
        }
      }
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_c_of_type_AndroidWidgetTextView.setId(2131361867);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(4.0F, getContext().getResources()), 0, AIOUtils.a(4.0F, getContext().getResources()), 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).topMargin = y;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = z;
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.C);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131361870);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberLevel mTopId = R.id.chat_item_nick_name_layout");
          }
        }
        addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((paramBoolean2) || (a()))
      {
        ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(2.0F, getContext().getResources());
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131361870);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(4, 2131361871);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
        if (paramInt1 != -1)
        {
          localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
          paramQQAppInterface = null;
          if (localTroopManager != null) {
            paramQQAppInterface = localTroopManager.a(paramInt1, paramString);
          }
          localObject = paramQQAppInterface;
          if (paramQQAppInterface == null)
          {
            paramQQAppInterface = TroopUtils.a(getResources(), paramInt1);
            localObject = paramQQAppInterface;
            if (localTroopManager != null)
            {
              localTroopManager.a(paramInt1, paramString, paramQQAppInterface);
              localObject = paramQQAppInterface;
            }
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(4.0F, getContext().getResources()), 0, AIOUtils.a(4.0F, getContext().getResources()), 0);
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("等级" + paramString);
      }
    }
    while ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        Object localObject;
        TroopManager localTroopManager;
        return;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = A;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131361863);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000))
    {
      paramChatMessage.isShowQimStyleAvater = QIMUserManager.a().a(paramObject, paramQQAppInterface, paramChatMessage);
      paramChatMessage.isShowQIMStyleGroup = QIMUserManager.a().a(paramObject, paramQQAppInterface, paramChatMessage, false);
      if (!paramChatMessage.isShowQimStyleAvater) {
        break label358;
      }
      paramObject = QIMUserManager.a().b(1);
      if (paramObject != null) {
        break label65;
      }
    }
    label65:
    label358:
    do
    {
      do
      {
        return;
        int i1 = getContext().getResources().getDimensionPixelSize(2131558624);
        int i2 = AIOUtils.a(28.0F, getContext().getResources());
        if (this.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
          this.jdField_a_of_type_AndroidWidgetImageView.setId(2131361864);
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          int i3 = AIOUtils.a(13.0F, getContext().getResources());
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramObject);
          paramObject = new RelativeLayout.LayoutParams(i3, i3);
          paramObject.topMargin = (i1 + i2);
          paramObject.leftMargin = i2;
          paramObject.addRule(7, 2131361863);
          paramObject.addRule(8, 2131361863);
          addView(this.jdField_a_of_type_AndroidWidgetImageView, paramObject);
        }
        while (paramChatMessage.istroop == 1)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 1, 0, "", "", "", "");
          return;
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          localLayoutParams.topMargin = (i1 + i2);
          localLayoutParams.leftMargin = i2;
          localLayoutParams.addRule(7, 2131361863);
          localLayoutParams.addRule(8, 2131361863);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramObject);
        }
      } while (paramChatMessage.istroop != 3000);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 1, 0, "", "", "", "");
      return;
      paramChatMessage.isShowQimStyleAvater = false;
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
  }
  
  void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_h_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_h_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_h_of_type_AndroidWidgetTextView.setId(2131361866);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_h_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_h_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
        this.jdField_h_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_h_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_h_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131558625);
        localLayoutParams.bottomMargin = this.jdField_h_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131558626);
        localLayoutParams.addRule(3, this.C);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131361870);
        }
        addView(this.jdField_h_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.leftMargin = this.jdField_h_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131558627);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(1, 2131361863);
      localLayoutParams.addRule(0, 0);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
      HotChatUtil.a(this.jdField_h_of_type_AndroidWidgetTextView, paramInt);
      this.jdField_h_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
      if (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    }
    while ((this.jdField_h_of_type_AndroidWidgetTextView == null) || (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 4))
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void a(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2, String paramString)
  {
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new RightLinearLayout(getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(53);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131361870);
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        paramString.topMargin = getContext().getResources().getDimensionPixelSize(2131558625);
        paramString.bottomMargin = getContext().getResources().getDimensionPixelSize(2131558626);
        paramString.addRule(3, this.C);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131361870);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramString);
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_g_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_g_of_type_AndroidWidgetTextView.setId(2131361872);
        this.jdField_g_of_type_AndroidWidgetTextView.setGravity(48);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_g_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_g_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_g_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_g_of_type_AndroidWidgetTextView, new LinearLayout.LayoutParams(-2, -2));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_f_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_f_of_type_AndroidWidgetTextView.setId(2131361871);
        this.jdField_f_of_type_AndroidWidgetTextView.setGravity(48);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_f_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_f_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_f_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_f_of_type_AndroidWidgetTextView.setMaxWidth(jdField_e_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetTextView, new LinearLayout.LayoutParams(-2, -2));
      }
      paramString = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (paramBoolean2)
      {
        paramString.rightMargin = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getDimensionPixelSize(2131558627);
        paramString.leftMargin = 0;
        paramString.addRule(0, 2131361863);
        paramString.addRule(1, 0);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131361870);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name_layout");
            }
          }
        }
        paramCharSequence2 = a("", this.jdField_g_of_type_AndroidWidgetTextView, jdField_e_of_type_Int, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramBoolean2);
        if (paramCharSequence2 == null) {
          break label793;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setText(paramCharSequence2);
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        label535:
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramCharSequence1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTag(paramCharSequence1);
        if (paramColorStateList1 != null) {
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList1);
        }
      }
    }
    label793:
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0))
          {
            paramString.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
            paramString.addRule(1, 2131361868);
          }
          for (;;)
          {
            paramString.rightMargin = 0;
            paramString.addRule(0, 0);
            break;
            if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0))
            {
              paramString.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
              paramString.addRule(1, 2131361868);
            }
            else if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
            {
              paramString.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
              paramString.addRule(1, 2131361867);
            }
            else if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 0))
            {
              paramString.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
              paramString.addRule(1, 2131361866);
            }
            else
            {
              paramString.leftMargin = this.jdField_f_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131558627);
              paramString.addRule(1, 2131361863);
            }
          }
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          break label535;
        } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      } while (this.jdField_a_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.C);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setNick mTopId = " + this.C);
  }
  
  public boolean a()
  {
    return this.B == 1;
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString, boolean paramBoolean, float paramFloat, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < EmojiStickerManager.jdField_f_of_type_Int)
    {
      EmojiStickerManager.Sticker localSticker = new EmojiStickerManager.Sticker();
      if (paramDrawable != null)
      {
        localSticker.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localSticker.jdField_a_of_type_Int = paramInt1;
      localSticker.jdField_b_of_type_Int = paramInt2;
      localSticker.jdField_c_of_type_Int = paramInt3;
      localSticker.jdField_d_of_type_Int = paramInt4;
      localSticker.jdField_a_of_type_Double = paramDouble;
      localSticker.jdField_a_of_type_JavaLangString = paramString;
      localSticker.jdField_a_of_type_Boolean = paramBoolean;
      localSticker.jdField_a_of_type_Float = paramFloat;
      localSticker.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = paramStickerInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localSticker);
      return true;
    }
    return false;
  }
  
  @TargetApi(16)
  public void addChildrenForAccessibility(ArrayList paramArrayList)
  {
    int i2;
    int i1;
    do
    {
      try
      {
        super.addChildrenForAccessibility(paramArrayList);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i2 = getChildCount();
        i1 = 0;
      }
    } while (i1 >= i2);
    View localView = getChildAt(i1);
    if (localView.getVisibility() == 0)
    {
      if (!localView.includeForAccessibility()) {
        break label57;
      }
      paramArrayList.add(localView);
    }
    for (;;)
    {
      i1 += 1;
      break;
      label57:
      localView.addChildrenForAccessibility(paramArrayList);
    }
  }
  
  public TextView b()
  {
    return this.jdField_f_of_type_AndroidWidgetTextView;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = true;
    invalidate();
  }
  
  void b(QQAppInterface paramQQAppInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_e_of_type_AndroidWidgetTextView.setId(2131361868);
        this.jdField_e_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_e_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(2.0F, this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources()));
        this.jdField_e_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(4.0F, this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources()), 0, AIOUtils.a(4.0F, this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources()), 0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText("LV" + paramInt);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramQQAppInterface = this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources().getDrawable(2130842873);
        arrayOfInt = NearbyFlowerUtil.a(this.jdField_e_of_type_AndroidWidgetTextView.getContext());
        i2 = Color.parseColor("#FFCC59");
        i1 = i2;
        if (arrayOfInt != null)
        {
          i1 = i2;
          if (paramInt < arrayOfInt.length) {
            i1 = arrayOfInt[paramInt];
          }
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(TroopUtils.a(this.jdField_e_of_type_AndroidWidgetTextView.getContext().getResources(), i1, paramQQAppInterface));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
        paramQQAppInterface.bottomMargin = DisplayUtil.a(getContext(), 1.0F);
        paramQQAppInterface.topMargin = DisplayUtil.a(getContext(), 1.0F);
        paramQQAppInterface.addRule(6, 2131361870);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131361870);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_e_of_type_AndroidWidgetTextView, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
      if (a())
      {
        paramQQAppInterface.rightMargin = AIOUtils.a(2.0F, getContext().getResources());
        if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.addRule(0, 2131361870);
          paramQQAppInterface.addRule(1, 0);
          paramQQAppInterface.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams();
          paramQQAppInterface.addRule(0, 2131361868);
          paramQQAppInterface.addRule(1, 0);
          this.jdField_e_of_type_AndroidWidgetTextView.setText("LV" + paramInt);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
    }
    while ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        int[] arrayOfInt;
        int i2;
        int i1;
        return;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(0, 2131361870);
        paramQQAppInterface.addRule(1, 0);
        continue;
        if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 0))
        {
          paramQQAppInterface.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131361866);
          paramQQAppInterface.addRule(0, 0);
        }
        else
        {
          paramQQAppInterface.leftMargin = A;
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131361863);
          paramQQAppInterface.addRule(0, 0);
        }
      }
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < EmojiStickerManager.jdField_e_of_type_Int);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    try
    {
      a(paramCanvas);
      return;
    }
    catch (OutOfMemoryError paramCanvas)
    {
      QLog.e("BaseChatItemLayout", 1, "dispatchDraw oom");
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (jdField_a_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() != 0) {
        break label46;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "BaseChatItemLayout onInterceptTouchEvent...down ");
      }
    }
    while (a(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      return true;
    }
    label46:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_d_of_type_Boolean = false;
      paramInt1 = getMeasuredHeight();
      i1 = getChildCount() - 1;
      if (i1 >= 0)
      {
        Object localObject = getChildAt(i1);
        if ((localObject == null) || (((View)localObject).getId() != 2131361877)) {
          break label254;
        }
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        paramInt2 = 0;
        int i3 = 0;
        while (paramInt2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
          localSticker.jdField_f_of_type_Int = 255;
          localSticker.jdField_e_of_type_Int = 0;
          int i2 = paramInt1;
          if (localSticker.jdField_b_of_type_Int + localSticker.jdField_d_of_type_Int > paramInt1)
          {
            i3 = 1;
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = (localSticker.jdField_b_of_type_Int + localSticker.jdField_d_of_type_Int - paramInt1);
            i2 = localSticker.jdField_b_of_type_Int + localSticker.jdField_d_of_type_Int;
          }
          paramInt2 += 1;
          paramInt1 = i2;
        }
        if (i3 == 0)
        {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      i1 -= 1;
      paramInt1 = paramInt2;
      break;
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
      paramInt2 = paramInt1;
      if (QLog.isColorLevel())
      {
        QLog.d("BaseChatItemLayout", 2, "onMeasure bubbleBottm = " + paramInt1);
        paramInt2 = paramInt1;
        continue;
        return;
        label254:
        paramInt2 = paramInt1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (jdField_a_of_type_Boolean) {
      if (paramMotionEvent.getAction() == 0) {
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg", 4, "BaseChatItemLayout onTouchEvent...down ");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
              } while (paramMotionEvent.getAction() != 1);
              paramMotionEvent = findViewById(2131361884);
            } while ((paramMotionEvent == null) || (!(paramMotionEvent instanceof CheckBox)) || (paramMotionEvent.getVisibility() != 0));
            paramMotionEvent = (CheckBox)paramMotionEvent;
            if (!paramMotionEvent.isChecked()) {
              bool = true;
            }
            paramMotionEvent.setChecked(bool);
            return true;
            if (!a(paramMotionEvent.getX(), paramMotionEvent.getY())) {
              break label188;
            }
            if (paramMotionEvent.getAction() != 0) {
              break;
            }
          } while ((this.jdField_a_of_type_AndroidViewMotionEvent == null) || (!a(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent)));
          this.jdField_e_of_type_Boolean = true;
        } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerDoubleClickListener == null);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerDoubleClickListener.a(this);
        return true;
      } while (paramMotionEvent.getAction() != 1);
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    } while (!this.jdField_e_of_type_Boolean);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewMotionEvent = null;
    return true;
    label188:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBubbleView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_a_of_type_AndroidViewView);
      if ((paramView instanceof HorizontalListView)) {
        break label165;
      }
      addView(paramView);
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewView.setId(2131361877);
      if (!(paramView instanceof HorizontalListView))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        int i1 = paramView.getContext().getResources().getDimensionPixelSize(2131558619);
        localLayoutParams.leftMargin = i1;
        localLayoutParams.rightMargin = i1;
        if (this.B != 1) {
          break label174;
        }
        localLayoutParams.addRule(0, 2131361863);
        localLayoutParams.addRule(1, 0);
      }
    }
    label107:
    paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if ((this.jdField_f_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      paramView.addRule(3, 2131361870);
      paramView.topMargin = 0;
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_nick_name_layout");
      }
    }
    label165:
    label174:
    do
    {
      return;
      addView(paramView, 0);
      break;
      localLayoutParams.addRule(1, 2131361863);
      localLayoutParams.addRule(0, 0);
      break label107;
      paramView.addRule(3, this.C);
      paramView.topMargin = k;
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setBubbleView mTopId  = " + this.C);
  }
  
  public void setCheckBox(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = jdField_a_of_type_Boolean;
    if (jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
        this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130838346);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131361884);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(AIOUtils.a(25.0F, getContext().getResources()), AIOUtils.a(25.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = v;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.C);
        addView(this.jdField_a_of_type_AndroidWidgetCheckBox, paramBaseChatItemLayout);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramChatMessage);
        if (!bool) {
          break label244;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        if (!MultiMsgManager.a().a(paramChatMessage)) {
          break label235;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
    label235:
    label244:
    while (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
    {
      for (;;)
      {
        return;
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(AIOUtils.a(25.0F, getContext().getResources()), AIOUtils.a(25.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = v;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.C);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams(paramBaseChatItemLayout);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_c_of_type_AndroidWidgetImageView.setId(2131361876);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131437074));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.a(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131361877);
      if (this.B != 1) {
        break label157;
      }
      localLayoutParams.addRule(0, 2131361877);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      addView(this.jdField_c_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      return;
      label157:
      localLayoutParams.addRule(1, 2131361877);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      setFailedIconResource(2130837752, paramOnClickListener);
    }
    for (;;)
    {
      if ((jdField_a_of_type_Boolean) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      return;
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
    }
  }
  
  public void setGrayTipsText(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131361862);
        int i1 = AIOUtils.a(12.0F, getContext().getResources());
        int i2 = AIOUtils.a(5.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842213);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        if (paramColorStateList != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i1, i2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
        if (paramInt <= 0)
        {
          paramInt = -2;
          paramColorStateList = new RelativeLayout.LayoutParams(paramInt, -2);
          paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131558611);
          paramInt = AIOUtils.a(45.0F, getContext().getResources());
          paramColorStateList.leftMargin = paramInt;
          paramColorStateList.rightMargin = paramInt;
          paramColorStateList.addRule(14);
          paramColorStateList.addRule(3, 2131361861);
          addView(this.jdField_b_of_type_AndroidWidgetTextView, paramColorStateList);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((paramCharSequence != null) && (!paramCharSequence.equals(this.jdField_b_of_type_AndroidWidgetTextView.getTag())))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
          this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
        }
        b(2131361862);
        label273:
        if ((this.C != 2131361861) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
          break label398;
        }
        paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        paramCharSequence.topMargin = getContext().getResources().getDimensionPixelSize(2131558610);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
      }
    }
    label398:
    while ((this.C != 2131361862) || (this.jdField_b_of_type_AndroidWidgetTextView == null))
    {
      return;
      paramInt = AIOUtils.a(paramInt, getContext().getResources());
      break;
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label273;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
      for (paramInt = 2131361861;; paramInt = 0)
      {
        b(paramInt);
        break;
      }
    }
    paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    paramCharSequence.topMargin = AIOUtils.a(10.0F, getContext().getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setVisibility(0);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if (!paramBoolean) {
        break label56;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      setPendantImageVisible(paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setVisibility(8);
      break;
      label56:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void setHeaderIcon(Object paramObject)
  {
    int i1 = getContext().getResources().getDimensionPixelSize(2131558624);
    int i2 = AIOUtils.a(5.0F, getContext().getResources());
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = new DynamicAvatarView(getContext());
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setId(2131361863);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setScaleType(ImageView.ScaleType.FIT_XY);
      int i3 = AIOUtils.a(40.0F, getContext().getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i3, i3);
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131361862);
      if (this.B == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i2;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.C);
        addView(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, localLayoutParams);
        label167:
        if (!(paramObject instanceof Drawable)) {
          break label417;
        }
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable((Drawable)paramObject);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131361862);
      if (this.B == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i2;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.C);
        break label167;
      }
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      label417:
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable((DynamicFaceDrawable)paramObject);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.c = ((DynamicFaceDrawable)paramObject).e;
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    int i1;
    if (this.B != paramInt)
    {
      this.B = paramInt;
      if (paramInt != 1) {
        break label437;
      }
      i1 = 1;
      if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label634;
      }
    }
    label225:
    label614:
    label634:
    for (paramInt = this.jdField_a_of_type_AndroidWidgetTextView.getId();; paramInt = 0)
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
        paramInt = this.jdField_b_of_type_AndroidWidgetTextView.getId();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams()).addRule(9);
        }
        RelativeLayout.LayoutParams localLayoutParams;
        int i2;
        if ((this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView != null) && (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getVisibility() == 0))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
          i2 = AIOUtils.a(5.0F, getContext().getResources());
          if (i1 != 0)
          {
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.rightMargin = i2;
            localLayoutParams.leftMargin = 0;
            localLayoutParams.addRule(3, paramInt);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
            if (this.B != 1) {
              break label512;
            }
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.addRule(3, this.C);
          }
          i2 = paramInt;
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
          {
            i2 = paramInt;
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
            {
              ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, paramInt);
              i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getId();
            }
          }
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
            if (i1 == 0) {
              break label576;
            }
            localLayoutParams.addRule(0, 2131361863);
            localLayoutParams.addRule(1, 0);
            localLayoutParams.addRule(3, i2);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setHearIconPosition mTopId = " + i2);
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
            if (i1 == 0) {
              break label595;
            }
            localLayoutParams.addRule(0, 2131361877);
            localLayoutParams.addRule(1, 0);
          }
        }
        for (;;)
        {
          if (this.jdField_c_of_type_AndroidWidgetImageView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
            if (i1 == 0) {
              break label614;
            }
            localLayoutParams.addRule(0, 2131361877);
            localLayoutParams.addRule(1, 0);
          }
          return;
          i1 = 0;
          break;
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
          for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
          {
            localLayoutParams.rightMargin = 0;
            break;
          }
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
          {
            localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
            break label225;
          }
          localLayoutParams.leftMargin = 0;
          break label225;
          localLayoutParams.addRule(1, 2131361863);
          localLayoutParams.addRule(0, 0);
          break label318;
          localLayoutParams.addRule(1, 2131361877);
          localLayoutParams.addRule(0, 0);
        }
        localLayoutParams.addRule(1, 2131361877);
        localLayoutParams.addRule(0, 0);
        return;
      }
    }
  }
  
  public void setNetIconVisible(boolean paramBoolean) {}
  
  public void setPendantImage(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131361881);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, getContext().getResources()), AIOUtils.a(59.0F, getContext().getResources()));
      localLayoutParams.addRule(3, 2131361862);
      if (this.B == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = 0;
        localLayoutParams.leftMargin = 0;
      }
      for (;;)
      {
        localLayoutParams.addRule(3, this.C);
        addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
          localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
        } else {
          localLayoutParams.leftMargin = 0;
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.addRule(3, 2131361862);
    if (this.B == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.C);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
      } else {
        localLayoutParams.leftMargin = 0;
      }
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    URLImageView localURLImageView;
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localURLImageView.setVisibility(i1);
      return;
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131361875);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838602));
        i1 = AIOUtils.a(16.0F, getContext().getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
        localLayoutParams.bottomMargin = AIOUtils.a(18.0F, getContext().getResources());
        localLayoutParams.addRule(8, 2131361877);
        if (this.B == 1)
        {
          localLayoutParams.rightMargin = AIOUtils.a(4.0F, getContext().getResources());
          localLayoutParams.addRule(0, 2131361877);
          localLayoutParams.addRule(1, 0);
          addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      for (;;)
      {
        int i1;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131361877);
        localLayoutParams.addRule(0, 0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void setRobotNextTipsView(boolean paramBoolean, Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView = new TroopRobotNextTipsView(getContext(), paramContext, paramQQAppInterface);
        paramContext = new RelativeLayout.LayoutParams(jdField_d_of_type_Int, -2);
        i2 = n;
        i1 = o;
        if (paramChatMessage.isSend())
        {
          i2 = o;
          i1 = n;
        }
        paramContext.addRule(3, 2131361877);
        paramContext.addRule(5, 2131361877);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setPadding(i2, 0, i1, 0);
        addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView, paramContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.a(paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setVisibility(0);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView == null)
    {
      int i2;
      int i1;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setVisibility(8);
  }
  
  public void setStickerPressStatus(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean != this.jdField_c_of_type_Boolean) {
      invalidate();
    }
    this.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTailMessage(paramBoolean, paramCharSequence, paramOnClickListener, true);
  }
  
  public void setTailMessage(boolean paramBoolean1, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_i_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_i_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_i_of_type_AndroidWidgetTextView.setId(2131361878);
        if (paramBoolean2)
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundResource(2130845632);
          this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
          this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-1);
          this.jdField_i_of_type_AndroidWidgetTextView.setGravity(17);
          this.jdField_i_of_type_AndroidWidgetTextView.setPadding(24, 0, 24, 0);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131361877);
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131361877);
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 0);
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = jdField_h_of_type_Int;
          addView(this.jdField_i_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
          localObject = new View(getContext());
          localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
          localLayoutParams.addRule(3, 2131361878);
          localLayoutParams.addRule(5, 2131361877);
          addView((View)localObject, localLayoutParams);
        }
      }
      else
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramCharSequence != this.jdField_i_of_type_AndroidWidgetTextView.getTag()) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        }
        paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_i_of_type_AndroidWidgetTextView.getLayoutParams();
        if (this.B != 1) {
          break label273;
        }
        paramCharSequence.leftMargin = j;
        this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      }
    }
    label273:
    while (this.jdField_i_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        Object localObject;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundResource(2130839657);
        continue;
        paramCharSequence.leftMargin = jdField_i_of_type_Int;
      }
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setTimeStamp(boolean paramBoolean, long paramLong, ColorStateList paramColorStateList, CharSequence paramCharSequence)
  {
    int i1 = 2131361862;
    if ((paramBoolean) && (paramLong > 0L))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131361861);
        i1 = AIOUtils.a(14.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 11.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, 0, i1, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(2131558610);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131558611);
        localLayoutParams.addRule(14);
        addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      }
      if (paramColorStateList != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)this.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramLong)
      {
        if (paramCharSequence != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
          break label282;
        }
        i1 = 2131361862;
        b(i1);
      }
    }
    label282:
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramColorStateList = TimeFormatterUtils.a(getContext(), 3, 1000L * paramLong);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColorStateList);
        continue;
        i1 = 2131361861;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    for (;;)
    {
      b(i1);
      return;
      i1 = 0;
    }
  }
  
  public void setUnread(boolean paramBoolean, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramOnClickListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnClickListener.topMargin = AIOUtils.a(8.0F, getContext().getResources());
      paramOnClickListener.leftMargin = AIOUtils.a(-3.0F, getContext().getResources());
      paramOnClickListener.addRule(6, 2131361877);
      paramOnClickListener.addRule(1, 2131361877);
      addView(this.jdField_d_of_type_AndroidWidgetImageView, paramOnClickListener);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846134);
    }
    while (this.jdField_d_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */