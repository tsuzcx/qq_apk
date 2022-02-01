package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewWrapperFactory;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BubbleViewWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IBubbleViewProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.INickNameLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor.NickNameLayoutData;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutViewWrapper;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.selectable.SelectableCursor;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.LeftSwipeReplyHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.Sticker;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerDoubleClickListener;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.MosaicURLImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQViewCompatUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseChatItemLayout
  extends ChatItemAnimLayout
  implements SelectCursorTouchHelper.SelectCursorTouchHelperListener, SelectableCursor
{
  public static final int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static int L;
  public static int M;
  public static int N;
  public static int O;
  public static int P;
  public static int Q;
  public static int R;
  public static int S;
  public static int T;
  public static int U;
  public static int V;
  public static int W;
  public static final float a;
  public static final int a;
  public static CompoundButton.OnCheckedChangeListener a;
  public static BaseChatItemLayout.OnChatMessageCheckedChangeListener a;
  public static boolean a;
  private static final int ab;
  private static final int ac;
  public static final float b;
  public static final int b;
  public static final float c;
  public static final int c;
  @Deprecated
  public static final float d;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
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
  public static final int w;
  public static final int x;
  public static int y;
  public static final int z;
  int X = 0;
  int Y;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public CheckBox a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public URLImageView a;
  BaseChatItemLayout.MiniAioShieldItemTouchListener jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$MiniAioShieldItemTouchListener = null;
  private BaseChatItemLayoutViewWrapperFactory jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewWrapperFactory;
  private SelectableDelegate jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public EmojiStickerManager.StickerDoubleClickListener a;
  TroopRobotNextTipsView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView;
  public ArrayList<EmojiStickerManager.Sticker> a;
  protected int[] a;
  private int ad = -1;
  private int ae = -1;
  private int af = -1;
  private int ag = -1;
  private int ah = -1;
  private int ai = -1;
  private int aj;
  private int ak = -1;
  private int al = -1;
  private int am = -1;
  private int an = 0;
  private int ao = 0;
  private int ap = 0;
  private int aq = 0;
  public ImageView b;
  TextView b;
  private TextView c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.b(5.0F);
    ab = ViewUtils.b(2.0F);
    ac = ViewUtils.b(18.0F);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    jdField_d_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131296453);
    jdField_b_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131299127);
    jdField_c_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131296453);
    jdField_h_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131296382);
    jdField_i_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131296381);
    jdField_j_of_type_Int = localBaseApplication.getResources().getDimensionPixelSize(2131296380);
    k = localBaseApplication.getResources().getDimensionPixelSize(2131296379);
    l = localBaseApplication.getResources().getDimensionPixelSize(2131296378);
    m = localBaseApplication.getResources().getDimensionPixelSize(2131296449);
    n = localBaseApplication.getResources().getDimensionPixelSize(2131296448);
    o = localBaseApplication.getResources().getDimensionPixelSize(2131296447);
    p = localBaseApplication.getResources().getDimensionPixelSize(2131296446);
    s = localBaseApplication.getResources().getDimensionPixelSize(2131296438);
    r = localBaseApplication.getResources().getDimensionPixelSize(2131296388);
    q = localBaseApplication.getResources().getDimensionPixelSize(2131296431);
    jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
    jdField_c_of_type_Int = localDisplayMetrics.heightPixels;
    jdField_d_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    jdField_e_of_type_Int = (int)(jdField_d_of_type_Int - jdField_d_of_type_Float * 108.0F);
    jdField_f_of_type_Int = jdField_e_of_type_Int - jdField_j_of_type_Int - k;
    jdField_g_of_type_Int = jdField_f_of_type_Int - s * 2;
    t = localBaseApplication.getResources().getDimensionPixelSize(2131296425);
    u = localBaseApplication.getResources().getDimensionPixelSize(2131296426);
    v = localBaseApplication.getResources().getDimensionPixelSize(2131296427);
    w = localBaseApplication.getResources().getDimensionPixelSize(2131296423);
    x = localBaseApplication.getResources().getDimensionPixelSize(2131296413);
    y = localBaseApplication.getResources().getDimensionPixelSize(2131296411);
    B = localBaseApplication.getResources().getDimensionPixelSize(2131299077);
    B = Math.min(B, jdField_f_of_type_Int);
    int i1 = jdField_d_of_type_Int - t - u - localBaseApplication.getResources().getDimensionPixelSize(2131299072) * 2;
    int i2 = jdField_j_of_type_Int + k + B;
    z = Math.min(i1, i2);
    if (jdField_d_of_type_Int < 1441) {
      A = i1;
    } else {
      A = Math.min(i1, i2);
    }
    C = localBaseApplication.getResources().getDimensionPixelSize(2131296421);
    D = localBaseApplication.getResources().getDimensionPixelSize(2131296420);
    E = localBaseApplication.getResources().getDimensionPixelSize(2131296419);
    F = localBaseApplication.getResources().getDimensionPixelSize(2131296409);
    G = localBaseApplication.getResources().getDimensionPixelSize(2131296408);
    H = localBaseApplication.getResources().getDimensionPixelSize(2131296407);
    I = localBaseApplication.getResources().getDimensionPixelSize(2131296402);
    J = localBaseApplication.getResources().getDimensionPixelSize(2131296404);
    K = localBaseApplication.getResources().getDimensionPixelSize(2131296403);
    M = localBaseApplication.getResources().getDimensionPixelSize(2131296406);
    L = localBaseApplication.getResources().getDimensionPixelSize(2131296405);
    N = localBaseApplication.getResources().getDimensionPixelSize(2131296456);
    O = localBaseApplication.getResources().getDimensionPixelSize(2131296455);
    P = localBaseApplication.getResources().getDimensionPixelSize(2131296457);
    Q = AIOUtils.b(26.0F, localBaseApplication.getResources());
    R = localBaseApplication.getResources().getDimensionPixelSize(2131296412);
    S = localBaseApplication.getResources().getDimensionPixelSize(2131296430);
    T = localBaseApplication.getResources().getDimensionPixelSize(2131296428);
    U = localBaseApplication.getResources().getDimensionPixelSize(2131296429);
    V = localBaseApplication.getResources().getDimensionPixelSize(2131296415);
    W = localBaseApplication.getResources().getDimensionPixelSize(2131296414);
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new BaseChatItemLayout.2();
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewWrapperFactory = new BaseChatItemLayoutViewWrapperFactory(this, paramContext);
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i3 = this.ad;
    int i2 = jdField_a_of_type_Int;
    int i1 = i3 - i2 * 3;
    i3 += i2 * 3;
    int i4 = this.ae;
    i2 = i4 - ac - i2 * 2;
    if ((paramFloat1 >= i1) && (paramFloat1 <= i3) && (paramFloat2 >= i2) && (paramFloat2 <= i4) && (this.jdField_d_of_type_Boolean)) {
      return 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isTouchOnCursor, left=");
      localStringBuilder.append(i1);
      localStringBuilder.append(",right=");
      localStringBuilder.append(i3);
      localStringBuilder.append(",top=");
      localStringBuilder.append(i2);
      localStringBuilder.append(", bottom=");
      localStringBuilder.append(i4);
      localStringBuilder.append(", x=");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(",y=");
      localStringBuilder.append(paramFloat2);
      QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
    }
    i1 = this.af;
    i2 = jdField_a_of_type_Int;
    i3 = this.ag;
    i4 = ac;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i1 + i2 * 3) && (paramFloat2 >= i3 - i4) && (paramFloat2 <= i3 + i2 * 2) && (this.jdField_e_of_type_Boolean)) {
      return 2;
    }
    return -1;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = this.ak;
    if (i1 == 1)
    {
      i1 = this.ah;
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt, i1, paramBoolean);
      }
    }
    else if (i1 == 2)
    {
      i1 = this.ai;
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt, i1, paramBoolean);
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = findViewById(2131364521);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)((View)localObject).getTag(2131364568));
      this.an = ((View)localObject).getLeft();
      this.ao = ((View)localObject).getMeasuredWidth();
      this.ap = ((View)localObject).getTop();
      this.aq = ((View)localObject).getMeasuredHeight();
    }
    int i2;
    int i1;
    int i3;
    int i4;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i2 = 0;
      i1 = 0;
      while (i2 <= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((localObject != null) && (((ChatMessage)localObject).stickerHidden))
        {
          if (localSticker.jdField_a_of_type_Int + this.an + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2) {
            i3 = -400;
          } else {
            i3 = 400;
          }
          localSticker.jdField_e_of_type_Int = i3;
          localSticker.jdField_f_of_type_Int = 0;
        }
        i4 = paramCanvas.getSaveCount();
        paramCanvas.save();
        i3 = localSticker.jdField_a_of_type_Int + this.an;
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
          boolean bool;
          if ((localSticker.jdField_c_of_type_Int - localSticker.jdField_g_of_type_Int >= 0) && (localSticker.jdField_d_of_type_Int - localSticker.jdField_h_of_type_Int >= 0)) {
            bool = false;
          } else {
            bool = true;
          }
          localSticker.jdField_a_of_type_Boolean = bool;
          if (localSticker.jdField_a_of_type_ComTencentMobileqqEmoticonStickerInfo != null) {
            localSticker.jdField_a_of_type_ComTencentMobileqqEmoticonStickerInfo.isShown = localSticker.jdField_a_of_type_Boolean;
          }
          if (!localSticker.jdField_a_of_type_Boolean)
          {
            i4 = paramCanvas.getSaveCount();
            paramCanvas.save();
            paramCanvas.translate(i3 + localSticker.jdField_e_of_type_Int - localSticker.jdField_c_of_type_Int / 2 + localSticker.jdField_g_of_type_Int, localSticker.jdField_b_of_type_Int - localSticker.jdField_d_of_type_Int / 2 + localSticker.jdField_h_of_type_Int);
            paramCanvas.clipRect(0, 0, localSticker.jdField_c_of_type_Int, localSticker.jdField_d_of_type_Int);
            if (localSticker.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
              localObject = EmojiStickerManager.a().a(getContext()).mutate();
            } else {
              localObject = localSticker.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
            }
            ((Drawable)localObject).setBounds(0, 0, localSticker.jdField_c_of_type_Int, localSticker.jdField_d_of_type_Int);
            ((Drawable)localObject).draw(paramCanvas);
            paramCanvas.restoreToCount(i4);
            localSticker.jdField_g_of_type_Int += EmojiStickerManager.jdField_g_of_type_Int;
            localSticker.jdField_h_of_type_Int += EmojiStickerManager.jdField_g_of_type_Int;
            localSticker.jdField_a_of_type_Float -= EmojiStickerManager.jdField_a_of_type_Float;
            if (localSticker.jdField_a_of_type_Float < 1.0F) {
              localSticker.jdField_a_of_type_Float = 1.0F;
            }
          }
        }
        if (localSticker.jdField_a_of_type_Boolean) {
          localSticker.jdField_a_of_type_Float = 1.0F;
        }
        if (!localSticker.jdField_a_of_type_Boolean) {
          i1 = 1;
        }
        i2 += 1;
      }
      f();
    }
    else
    {
      i1 = 0;
    }
    if ((EmojiStickerManager.jdField_b_of_type_Boolean) || ((!EmojiStickerManager.jdField_b_of_type_Boolean) && (this.jdField_g_of_type_Boolean)))
    {
      i2 = paramCanvas.getSaveCount();
      i3 = this.an;
      i4 = this.ap;
      paramCanvas.clipRect(i3, i4, this.ao + i3, this.aq + i4);
      if (this.jdField_g_of_type_Boolean) {
        localObject = "#19000000";
      } else {
        localObject = "#00000000";
      }
      paramCanvas.drawColor(Color.parseColor((String)localObject));
      paramCanvas.restoreToCount(i2);
      if (!EmojiStickerManager.jdField_b_of_type_Boolean) {
        this.jdField_g_of_type_Boolean = false;
      }
    }
    if (i1 != 0) {
      invalidate();
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        int i1 = localSticker.jdField_a_of_type_Int;
        int i2 = this.an;
        int i5 = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.jdField_c_of_type_Int);
        int i4 = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.jdField_d_of_type_Int);
        int i3 = localSticker.jdField_e_of_type_Int;
        i5 /= 2;
        int i6 = localSticker.jdField_b_of_type_Int;
        i4 /= 2;
        float f1 = i1 + i2 + i3 - i5;
        if ((paramFloat1 > f1) && (paramFloat1 < f1 + localSticker.jdField_a_of_type_Float * localSticker.jdField_c_of_type_Int))
        {
          f1 = i6 - i4;
          if ((paramFloat2 > f1) && (paramFloat2 < f1 + localSticker.jdField_a_of_type_Float * localSticker.jdField_d_of_type_Int)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i2;
    if (!this.jdField_f_of_type_Boolean)
    {
      i2 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i2 != -1) && (i1 == 0))
      {
        e();
        this.jdField_f_of_type_Boolean = true;
        this.ak = i2;
        this.al = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b();
        this.am = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.c();
        if (paramMotionEvent.getSource() != -1) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.ak, false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b();
        }
        return true;
      }
      return false;
    }
    e();
    if ((i1 != 1) && (i1 != 3))
    {
      if (i1 == 2)
      {
        int i3 = (int)paramMotionEvent.getRawX();
        int i4 = (int)paramMotionEvent.getRawY();
        int i5 = this.ak;
        int[] arrayOfInt;
        if (i5 == 1)
        {
          i1 = this.ad;
          i2 = this.ae;
          i5 = ac;
          int i6 = jdField_a_of_type_Int;
          arrayOfInt = a(i3, i4, i1, i2, i6 * 2 + i5, -i5, this.jdField_d_of_type_Boolean, i6 * 2);
          i1 = arrayOfInt[0];
          i2 = arrayOfInt[1];
        }
        else
        {
          i1 = i3;
          i2 = i4;
          if (i5 == 2)
          {
            i1 = this.af;
            i2 = this.ag;
            i5 = jdField_a_of_type_Int;
            arrayOfInt = a(i3, i4, i1, i2, 0, i5 * 2, this.jdField_e_of_type_Boolean, -i5 * 2);
            i1 = arrayOfInt[0];
            i2 = arrayOfInt[1];
          }
        }
        c(i1, i2, paramMotionEvent.getSource());
        return true;
      }
    }
    else
    {
      this.jdField_f_of_type_Boolean = false;
      this.ah = -1;
      this.ai = -1;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(-1, true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a();
      if (i1 == 1)
      {
        if (paramMotionEvent.getSource() == -1) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        ReportController.b(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i1, 0, "", "", "", "");
      }
    }
    return true;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    long l1 = paramMotionEvent2.getEventTime();
    long l2 = paramMotionEvent1.getEventTime();
    boolean bool = false;
    if (l1 - l2 > 200L) {
      return false;
    }
    int i1 = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
    int i2 = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    if (i1 * i1 + i2 * i2 < 10000) {
      bool = true;
    }
    return bool;
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    int i2 = jdField_a_of_type_Int;
    int i1 = paramInt2;
    if (paramInt1 >= paramInt3 - i2 * 3)
    {
      i1 = paramInt2;
      if (paramInt1 <= paramInt3 + i2 * 3)
      {
        i1 = paramInt2;
        if (paramInt2 >= paramInt4 - paramInt5)
        {
          i1 = paramInt2;
          if (paramInt2 <= paramInt4 + paramInt6)
          {
            i1 = paramInt2;
            if (paramBoolean) {
              i1 = paramInt2 + paramInt7;
            }
          }
        }
      }
    }
    return new int[] { paramInt1, i1 };
  }
  
  private void d(int paramInt)
  {
    if (this.Y != paramInt)
    {
      this.Y = paramInt;
      Object localObject = (HeadIconWrapper)a(HeadIconWrapper.class);
      if (localObject != null)
      {
        localObject = ((HeadIconWrapper)localObject).a();
        if (localObject != null) {
          ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.Y);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (localObject != null) {
        ((RelativeLayout.LayoutParams)((URLImageView)localObject).getLayoutParams()).addRule(3, this.Y);
      }
      localObject = (NickNameLayoutViewWrapper)a(NickNameLayoutViewWrapper.class);
      BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility;
      if (localObject != null)
      {
        localBaseChatItemLayoutViewBasicAbility = ((NickNameLayoutViewWrapper)localObject).a().c();
        if ((localBaseChatItemLayoutViewBasicAbility != null) && (localBaseChatItemLayoutViewBasicAbility.checkViewNonNull())) {
          ((RelativeLayout.LayoutParams)localBaseChatItemLayoutViewBasicAbility.getLayoutParams()).addRule(3, this.Y);
        }
        localObject = ((NickNameLayoutViewWrapper)localObject).a();
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull())) {
          ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.Y);
        }
      }
      localObject = (BubbleViewWrapper)a(BubbleViewWrapper.class);
      if (localObject != null)
      {
        localObject = ((BubbleViewWrapper)localObject).a();
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()))
        {
          localBaseChatItemLayoutViewBasicAbility = a(NickNameChatItemLayoutProcessor.jdField_h_of_type_Int);
          if ((localBaseChatItemLayoutViewBasicAbility == null) || (!localBaseChatItemLayoutViewBasicAbility.checkViewNonNull()) || (localBaseChatItemLayoutViewBasicAbility.getViewVisibility() != 0))
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, this.Y);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" setTopId mTopId = ");
              ((StringBuilder)localObject).append(this.Y);
              QLog.d("BubbleView", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate != null) {
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  private void f()
  {
    if (this.jdField_i_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        boolean bool = false;
        while (((Iterator)localObject).hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
          if (localSticker.jdField_a_of_type_Int + this.an + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2)
          {
            if (Math.abs(localSticker.jdField_e_of_type_Int) > 200)
            {
              localSticker.jdField_e_of_type_Int -= EmojiStickerManager.jdField_f_of_type_Int;
              localSticker.jdField_f_of_type_Int -= Math.abs(EmojiStickerManager.jdField_f_of_type_Int / 2);
              localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
            }
            else
            {
              localSticker.jdField_f_of_type_Int += Math.abs(EmojiStickerManager.jdField_f_of_type_Int / 2);
              localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
              localSticker.jdField_e_of_type_Int += EmojiStickerManager.jdField_f_of_type_Int;
            }
            if (localSticker.jdField_e_of_type_Int <= 0) {
              break label362;
            }
            localSticker.jdField_e_of_type_Int = 0;
            if (EmojiStickerManager.jdField_a_of_type_AndroidViewView == null) {
              localSticker.jdField_f_of_type_Int = 255;
            }
            this.jdField_i_of_type_Boolean = false;
          }
          else
          {
            if (Math.abs(localSticker.jdField_e_of_type_Int) < 200)
            {
              localSticker.jdField_f_of_type_Int += Math.abs(EmojiStickerManager.jdField_f_of_type_Int / 2);
              localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
              localSticker.jdField_e_of_type_Int -= EmojiStickerManager.jdField_f_of_type_Int;
            }
            else
            {
              localSticker.jdField_f_of_type_Int -= Math.abs(EmojiStickerManager.jdField_f_of_type_Int / 2);
              localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
              localSticker.jdField_e_of_type_Int += EmojiStickerManager.jdField_f_of_type_Int;
            }
            if (localSticker.jdField_e_of_type_Int >= 0) {
              break label362;
            }
            localSticker.jdField_e_of_type_Int = 0;
            if (EmojiStickerManager.jdField_a_of_type_AndroidViewView == null) {
              localSticker.jdField_f_of_type_Int = 255;
            }
            this.jdField_i_of_type_Boolean = false;
          }
          bool = false;
          label362:
          if (localSticker.jdField_e_of_type_Int < -400)
          {
            localSticker.jdField_e_of_type_Int = -400;
            localSticker.jdField_f_of_type_Int = 0;
            this.jdField_i_of_type_Boolean = false;
            bool = true;
          }
          if (localSticker.jdField_e_of_type_Int > 400)
          {
            localSticker.jdField_e_of_type_Int = 400;
            localSticker.jdField_f_of_type_Int = 0;
            this.jdField_i_of_type_Boolean = false;
            bool = true;
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (localObject != null) {
          ((ChatMessage)localObject).stickerHidden = bool;
        }
        invalidate();
      }
    }
  }
  
  public int a()
  {
    return this.Y;
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)) {
      return -1;
    }
    return new SelectCursorTouchHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1) {
      return this.ad;
    }
    return this.af;
  }
  
  @NonNull
  public View a()
  {
    return this;
  }
  
  @Nullable
  public BaseChatItemLayoutViewBasicAbility a(int paramInt)
  {
    BaseChatItemLayoutViewWrapper localBaseChatItemLayoutViewWrapper = a(NickNameLayoutViewWrapper.class);
    if (localBaseChatItemLayoutViewWrapper != null) {
      return localBaseChatItemLayoutViewWrapper.a(paramInt);
    }
    return null;
  }
  
  @Nullable
  public <T extends BaseChatItemLayoutViewWrapper> T a(Class<? extends BaseChatItemLayoutViewWrapper> paramClass)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistBasechatItemlayoutBaseChatItemLayoutViewWrapperFactory.a(paramClass);
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    if ((localObject != null) && (((URLImageView)localObject).getVisibility() == 0))
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      if (this.X == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if ((localCheckBox != null) && (localCheckBox.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(25.0F, getContext().getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        }
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.Y);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_d_of_type_Boolean = false;
    } else {
      this.jdField_e_of_type_Boolean = false;
    }
    invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      int i1;
      if ((localObject != null) && (((ChatMessage)localObject).stickerHidden)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (i1 != 0))
        {
          int i2;
          if (localSticker.jdField_a_of_type_Int + this.an + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2) {
            i2 = -400;
          } else {
            i2 = 400;
          }
          localSticker.jdField_e_of_type_Int = i2;
          localSticker.jdField_f_of_type_Int = 0;
        }
        if ((paramInt2 != EmojiStickerManager.jdField_e_of_type_Int) || (localSticker.jdField_e_of_type_Int != 0)) {
          if (paramInt2 == EmojiStickerManager.jdField_d_of_type_Int)
          {
            if (localSticker.jdField_a_of_type_Int + this.an + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2) {
              localSticker.jdField_e_of_type_Int -= paramInt1;
            } else {
              localSticker.jdField_e_of_type_Int += paramInt1;
            }
            localSticker.jdField_f_of_type_Int -= Math.abs(paramInt1 / 2);
            localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
          }
          else if (paramInt2 == EmojiStickerManager.jdField_e_of_type_Int)
          {
            if (localSticker.jdField_a_of_type_Int + this.an + localSticker.jdField_c_of_type_Int / 2 < getMeasuredWidth() / 2)
            {
              localSticker.jdField_e_of_type_Int += paramInt1;
              if (localSticker.jdField_e_of_type_Int > 0) {
                localSticker.jdField_e_of_type_Int = 0;
              }
            }
            else
            {
              localSticker.jdField_e_of_type_Int -= paramInt1;
              if (localSticker.jdField_e_of_type_Int < 0) {
                localSticker.jdField_e_of_type_Int = 0;
              }
            }
            localSticker.jdField_f_of_type_Int += Math.abs(paramInt1 / 2);
            localSticker.jdField_f_of_type_Int = Math.min(255, Math.max(0, localSticker.jdField_f_of_type_Int));
          }
        }
        if (localSticker.jdField_e_of_type_Int < -400) {
          localSticker.jdField_e_of_type_Int = -400;
        }
        if (localSticker.jdField_e_of_type_Int > 400) {
          localSticker.jdField_e_of_type_Int = 400;
        }
      }
      if (i1 != 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (localObject != null) {
          ((ChatMessage)localObject).stickerHidden = false;
        }
      }
      invalidate();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.al = (paramInt1 - paramInt2);
      return;
    }
    this.am = (paramInt1 + paramInt2);
  }
  
  public void a(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    Object localObject = (ImageView)findViewById(2131364544);
    if (localObject == null)
    {
      localObject = new ImageView(paramContext);
      ((ImageView)localObject).setId(2131364544);
      ((ImageView)localObject).setImageResource(2130838034);
      int i1 = V;
      paramBaseAdapter = new RelativeLayout.LayoutParams(i1, i1);
      paramBaseAdapter.leftMargin = (paramContext.getResources().getDisplayMetrics().widthPixels + W - getPaddingLeft());
      paramBaseAdapter.addRule(15, 2131364521);
      addView((View)localObject, paramBaseAdapter);
      ((ImageView)localObject).setVisibility(4);
      paramContext = (Context)localObject;
    }
    else
    {
      if ((getScrollX() != 0) && ((paramContext instanceof BaseActivity)))
      {
        paramContext = ((BaseActivity)paramContext).getChatFragment();
        if (paramContext != null)
        {
          paramContext = paramContext.a();
          if (paramContext != null)
          {
            paramContext = (LeftSwipeReplyHelper)paramContext.a(50);
            if (paramContext != null) {
              paramContext.a(this);
            }
          }
        }
      }
      paramBaseAdapter = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      paramContext = (Context)localObject;
    }
    localObject = a(BubbleViewWrapper.class);
    if (localObject != null)
    {
      localObject = ((BaseChatItemLayoutViewWrapper)localObject).a();
      if (localObject != null) {
        ((BaseChatItemLayoutViewBasicAbility)localObject).post(new BaseChatItemLayout.1(this, paramBaseAdapter, (BaseChatItemLayoutViewBasicAbility)localObject, paramContext));
      }
    }
  }
  
  protected void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramImageView != null)
    {
      paramImageView = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramImageView.addRule(0, 2131364521);
        paramImageView.addRule(1, 0);
        return;
      }
      paramImageView.addRule(1, 2131364521);
      paramImageView.addRule(0, 0);
    }
  }
  
  protected void a(ProgressBar paramProgressBar, boolean paramBoolean)
  {
    if (paramProgressBar != null)
    {
      paramProgressBar = (RelativeLayout.LayoutParams)paramProgressBar.getLayoutParams();
      if (paramBoolean)
      {
        paramProgressBar.addRule(0, 2131364521);
        paramProgressBar.addRule(1, 0);
        return;
      }
      paramProgressBar.addRule(1, 2131364521);
      paramProgressBar.addRule(0, 0);
    }
  }
  
  public void a(SelectableDelegate paramSelectableDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate = paramSelectableDelegate;
  }
  
  public boolean a()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    return (localTextView != null) && (localTextView.getVisibility() == 0);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_d_of_type_Boolean;
    }
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString, boolean paramBoolean, float paramFloat, StickerInfo paramStickerInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < QVipStickerProcessor.jdField_c_of_type_Int)
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
      localSticker.jdField_a_of_type_ComTencentMobileqqEmoticonStickerInfo = paramStickerInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localSticker);
      return true;
    }
    return false;
  }
  
  @TargetApi(16)
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    try
    {
      super.addChildrenForAccessibility(paramArrayList);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label6:
      int i2;
      int i1;
      break label6;
    }
    i2 = getChildCount();
    i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0) {
        if (QQViewCompatUtil.a(localView)) {
          paramArrayList.add(localView);
        } else {
          localView.addChildrenForAccessibility(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public int b()
  {
    return this.X;
  }
  
  public int b(int paramInt)
  {
    if (paramInt == 1) {
      return this.ae;
    }
    return this.ag;
  }
  
  public void b()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null)
    {
      this.jdField_i_of_type_Boolean = false;
      localArrayList.clear();
    }
  }
  
  public void b(int paramInt)
  {
    this.aj = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    e();
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    int[] arrayOfInt;
    if (paramInt3 == 1)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      this.ad = (paramInt1 - arrayOfInt[0]);
      this.ae = (paramInt2 - arrayOfInt[1]);
      this.jdField_d_of_type_Boolean = bool;
    }
    else
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      this.af = (paramInt1 - arrayOfInt[0]);
      this.ag = (paramInt2 - arrayOfInt[1]);
      this.jdField_e_of_type_Boolean = bool;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    if (paramInt3 == 1)
    {
      this.ah = paramInt2;
    }
    else if (paramInt3 == 2)
    {
      this.ai = paramInt2;
    }
    else
    {
      this.ah = -1;
      this.ai = -1;
    }
    invalidate();
  }
  
  public boolean b()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    return (localImageView != null) && (localImageView.getVisibility() == 0);
  }
  
  public void c()
  {
    this.jdField_i_of_type_Boolean = true;
    invalidate();
  }
  
  public void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        localSticker.jdField_b_of_type_Int += paramInt;
      }
    }
  }
  
  protected void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    if (this.ak == 1) {
      i2 = this.al;
    } else {
      i2 = this.am;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt1, paramInt2);
    if (paramInt3 == -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.ak, false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCursorLocation, touchIndex=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.ak);
      QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
    }
    if (i1 == -1) {
      return;
    }
    if (i1 != i2)
    {
      if (this.ak == 1)
      {
        paramInt3 = this.al;
        if (i1 < paramInt3)
        {
          paramInt3 = this.am;
          this.al = i1;
        }
      }
      for (;;)
      {
        i2 = i1;
        i1 = paramInt3;
        paramInt3 = i2;
        break;
        if (i1 > paramInt3)
        {
          paramInt3 = this.am;
          if (i1 < paramInt3)
          {
            this.al = i1;
            continue;
          }
        }
        paramInt3 = this.al;
        if (i1 == paramInt3)
        {
          i1 = this.am;
          break;
        }
        paramInt3 = this.am;
        if (i1 == paramInt3)
        {
          i1 = paramInt3 - 1;
        }
        else
        {
          this.al = paramInt3;
          this.am = i1;
          this.ak = 2;
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.ak);
          break;
          paramInt3 = this.am;
          if (i1 > paramInt3)
          {
            paramInt3 = this.al;
            this.am = i1;
            break;
          }
          if (i1 < paramInt3)
          {
            paramInt3 = this.al;
            if (i1 > paramInt3)
            {
              this.am = i1;
              break;
            }
          }
          paramInt3 = this.am;
          if (i1 == paramInt3)
          {
            i1 = this.al;
          }
          else
          {
            paramInt3 = this.al;
            if (i1 == paramInt3)
            {
              i1 = paramInt3 + 1;
              break;
            }
            this.am = paramInt3;
            this.al = i1;
            this.ak = 1;
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(this.ak);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update selection, s=");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(", e=");
        localStringBuilder.append(i1);
        QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.a(paramInt3, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.b(paramInt1, paramInt2);
      a(paramInt1, true);
      return;
    }
    a(paramInt1, false);
  }
  
  public boolean c()
  {
    return this.X == 1;
  }
  
  public void d()
  {
    setPendantImageVisible(false);
    View localView = findViewById(2131365992);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131367028);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131367027);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
  }
  
  public boolean d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList == null) || (localArrayList.size() < QVipStickerProcessor.jdField_b_of_type_Int);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    try
    {
      a(paramCanvas);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label13:
      Rect localRect;
      int i1;
      int i2;
      int i3;
      float f1;
      break label13;
    }
    QLog.e("BaseChatItemLayout", 1, "dispatchDraw oom");
    if (this.jdField_d_of_type_Boolean)
    {
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      i1 = this.ad;
      i2 = ab;
      i3 = this.ae;
      localRect.set(i1 - i2, i3 - ac, i1, i3);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.aj);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i2 = jdField_a_of_type_Int;
      paramCanvas.drawCircle(f1, i1 - i2, i2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_e_of_type_Boolean)
    {
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      i1 = this.af;
      i2 = this.ag;
      localRect.set(i1, i2 - ac, ab + i1, i2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.aj);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      i2 = jdField_a_of_type_Int;
      paramCanvas.drawCircle(f1, i1 + i2, i2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean e()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (jdField_a_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg_TAG", 4, "BaseChatItemLayout onInterceptTouchEvent...down ");
        }
        return true;
      }
    }
    else
    {
      if (a(paramMotionEvent.getX(), paramMotionEvent.getY())) {
        return true;
      }
      if (((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) && (a(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
      {
        e();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableSelectableDelegate.c();
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_i_of_type_Boolean = false;
      paramInt1 = getMeasuredHeight();
      paramInt2 = getChildCount() - 1;
      while (paramInt2 >= 0)
      {
        localObject = getChildAt(paramInt2);
        int i1 = paramInt1;
        if (localObject != null)
        {
          i1 = paramInt1;
          if (((View)localObject).getId() == 2131364521)
          {
            localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
            i1 = 0;
            int i3 = 0;
            while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
              localSticker.jdField_f_of_type_Int = 255;
              localSticker.jdField_e_of_type_Int = 0;
              int i2 = paramInt1;
              if (localSticker.jdField_b_of_type_Int + localSticker.jdField_d_of_type_Int > paramInt1)
              {
                ((RelativeLayout.LayoutParams)localObject).bottomMargin = (localSticker.jdField_b_of_type_Int + localSticker.jdField_d_of_type_Int - paramInt1);
                i2 = localSticker.jdField_b_of_type_Int + localSticker.jdField_d_of_type_Int;
                i3 = 1;
              }
              i1 += 1;
              paramInt1 = i2;
            }
            if (i3 == 0)
            {
              ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
            }
            else
            {
              setMeasuredDimension(getMeasuredWidth(), paramInt1);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("onMeasure bubbleBottm = ");
                ((StringBuilder)localObject).append(paramInt1);
                QLog.d("BaseChatItemLayout", 2, ((StringBuilder)localObject).toString());
              }
            }
            i1 = paramInt1;
          }
        }
        paramInt2 -= 1;
        paramInt1 = i1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    MotionEvent localMotionEvent = null;
    if (bool)
    {
      if ((paramMotionEvent.getAction() == 1) && (!this.jdField_c_of_type_Boolean))
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$MiniAioShieldItemTouchListener;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a_(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          QQToast.a(BaseApplication.getContext(), 0, HardCodeUtil.a(2131701208), 0).a();
          return true;
        }
        paramMotionEvent = localMotionEvent;
        if (BaseActivity.sTopActivity != null) {
          paramMotionEvent = BaseActivity.sTopActivity.app;
        }
        ReportController.b(paramMotionEvent, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "8", "", "", "");
      }
      return true;
    }
    if (jdField_a_of_type_Boolean)
    {
      AIOCheckBoxUtil.a(this, paramMotionEvent);
      return true;
    }
    if (a(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
        if ((localMotionEvent != null) && (a(localMotionEvent, paramMotionEvent)))
        {
          this.jdField_j_of_type_Boolean = true;
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerDoubleClickListener;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.a(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.jdField_j_of_type_Boolean)
        {
          this.jdField_j_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
        }
      }
      return true;
    }
    if (((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) && (a(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBubbleView(View paramView)
  {
    BubbleViewWrapper localBubbleViewWrapper = (BubbleViewWrapper)a(BubbleViewWrapper.class);
    if (localBubbleViewWrapper != null) {
      ((IBubbleViewProcessor)localBubbleViewWrapper.a()).a(paramView);
    }
  }
  
  public void setCheckBox(ChatMessage paramChatMessage)
  {
    boolean bool = jdField_a_of_type_Boolean;
    if (bool)
    {
      Object localObject;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
        this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130839072);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131364547);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        localObject = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, getContext().getResources()), AIOUtils.b(24.0F, getContext().getResources()));
        ((RelativeLayout.LayoutParams)localObject).topMargin = x;
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.Y);
        addView(this.jdField_a_of_type_AndroidWidgetCheckBox, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        localObject = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, getContext().getResources()), AIOUtils.b(24.0F, getContext().getResources()));
        ((RelativeLayout.LayoutParams)localObject).topMargin = x;
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.Y);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramChatMessage);
      if (bool)
      {
        localObject = AIOLongShotHelper.a();
        if ((localObject != null) && (((AIOLongShotHelper)localObject).a()))
        {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((AIOLongShotHelper)localObject).a(paramChatMessage));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        if (MultiMsgManager.a().a(paramChatMessage))
        {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      return;
    }
    paramChatMessage = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (paramChatMessage != null) {
      paramChatMessage.setVisibility(8);
    }
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364528);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131689897));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.b(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131364521);
      if (this.X == 1)
      {
        localLayoutParams.addRule(0, 2131364521);
        localLayoutParams.addRule(1, 0);
      }
      else
      {
        localLayoutParams.addRule(1, 2131364521);
        localLayoutParams.addRule(0, 0);
      }
      addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramObject);
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      setFailedIconResource(2130838217, paramOnClickListener);
    }
    else
    {
      paramOnClickListener = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramOnClickListener != null)
      {
        paramOnClickListener.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
    }
    if (jdField_a_of_type_Boolean)
    {
      paramOnClickListener = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramOnClickListener != null) {
        paramOnClickListener.setOnClickListener(null);
      }
    }
  }
  
  public void setGrayTipsText(boolean paramBoolean, ChatMessage paramChatMessage, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131364529);
        i1 = AIOUtils.b(12.0F, getContext().getResources());
        int i2 = AIOUtils.b(5.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844764);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        if (paramColorStateList != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i1, i2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
        if (paramInt <= 0) {
          paramInt = -2;
        } else {
          paramInt = AIOUtils.b(paramInt, getContext().getResources());
        }
        paramColorStateList = new RelativeLayout.LayoutParams(paramInt, -2);
        paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131296455);
        paramInt = AIOUtils.b(45.0F, getContext().getResources());
        paramColorStateList.leftMargin = paramInt;
        paramColorStateList.rightMargin = paramInt;
        paramColorStateList.addRule(14);
        paramColorStateList.addRule(3, 2131364552);
        addView(this.jdField_b_of_type_AndroidWidgetTextView, paramColorStateList);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((paramCharSequence != null) && (!paramCharSequence.equals(this.jdField_b_of_type_AndroidWidgetTextView.getTag())))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
      }
      d(2131364529);
    }
    else
    {
      paramCharSequence = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramCharSequence != null)
      {
        paramCharSequence.setVisibility(8);
        paramCharSequence = this.jdField_a_of_type_AndroidWidgetTextView;
        paramInt = i1;
        if (paramCharSequence != null)
        {
          paramInt = i1;
          if (paramCharSequence.getVisibility() == 0) {
            paramInt = 2131364552;
          }
        }
        d(paramInt);
      }
    }
    if (this.Y == 2131364552)
    {
      paramCharSequence = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramCharSequence != null)
      {
        paramCharSequence = (RelativeLayout.LayoutParams)paramCharSequence.getLayoutParams();
        paramInt = N;
        if (paramChatMessage.isFirstMsg)
        {
          paramInt = N;
          paramInt = P + paramInt;
        }
        paramCharSequence.topMargin = paramInt;
        return;
      }
    }
    if (this.Y == 2131364529)
    {
      paramChatMessage = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramChatMessage != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramChatMessage.getLayoutParams();
        paramChatMessage.topMargin = AIOUtils.b(10.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
      }
    }
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    HeadIconWrapper localHeadIconWrapper = (HeadIconWrapper)a(HeadIconWrapper.class);
    if (localHeadIconWrapper != null) {
      ((IHeadIconProcessor)localHeadIconWrapper.a()).b(paramBoolean);
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    if (this.X != paramInt)
    {
      this.X = paramInt;
      int i1 = 0;
      boolean bool = true;
      if (paramInt != 1) {
        bool = false;
      }
      Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      paramInt = i1;
      if (localObject != null)
      {
        paramInt = i1;
        if (((TextView)localObject).getVisibility() == 0) {
          paramInt = this.jdField_a_of_type_AndroidWidgetTextView.getId();
        }
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      i1 = paramInt;
      if (localObject != null)
      {
        i1 = paramInt;
        if (((TextView)localObject).getVisibility() == 0) {
          i1 = this.jdField_b_of_type_AndroidWidgetTextView.getId();
        }
      }
      localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (localObject != null) {
        ((RelativeLayout.LayoutParams)((CheckBox)localObject).getLayoutParams()).addRule(9);
      }
      localObject = (HeadIconWrapper)a(HeadIconWrapper.class);
      if (localObject != null) {
        ((IHeadIconProcessor)((HeadIconWrapper)localObject).a()).a(bool, i1);
      }
      a();
      localObject = (NickNameLayoutViewWrapper)a(NickNameLayoutViewWrapper.class);
      paramInt = i1;
      if (localObject != null)
      {
        localObject = ((NickNameLayoutViewWrapper)localObject).a();
        paramInt = i1;
        if (localObject != null)
        {
          paramInt = i1;
          if (((BaseChatItemLayoutViewBasicAbility)localObject).getViewVisibility() == 0)
          {
            ((RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject).getLayoutParams()).addRule(3, i1);
            paramInt = ((BaseChatItemLayoutViewBasicAbility)localObject).getId();
          }
        }
      }
      localObject = (BubbleViewWrapper)a(BubbleViewWrapper.class);
      if (localObject != null) {
        ((IBubbleViewProcessor)((BubbleViewWrapper)localObject).a()).a(bool, paramInt);
      }
      a(this.jdField_a_of_type_AndroidWidgetProgressBar, bool);
      a(this.jdField_a_of_type_AndroidWidgetImageView, bool);
    }
  }
  
  public void setMiniAioShieldItemTouchListener(BaseChatItemLayout.MiniAioShieldItemTouchListener paramMiniAioShieldItemTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$MiniAioShieldItemTouchListener = paramMiniAioShieldItemTouchListener;
  }
  
  public void setNetIconVisible(boolean paramBoolean) {}
  
  public void setNick(boolean paramBoolean, NickNameChatItemLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    NickNameLayoutViewWrapper localNickNameLayoutViewWrapper = (NickNameLayoutViewWrapper)a(NickNameLayoutViewWrapper.class);
    if (localNickNameLayoutViewWrapper != null) {
      ((INickNameLayoutProcessor)localNickNameLayoutViewWrapper.a()).a(paramBoolean, paramNickNameLayoutData);
    }
  }
  
  public void setNick(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2, String paramString)
  {
    setNick(paramBoolean1, new NickNameChatItemLayoutProcessor.NickNameLayoutData(paramCharSequence1, paramColorStateList1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramString, -100, -100, -100, -100, -100, -100, -100));
  }
  
  public void setPendantImage(Drawable paramDrawable)
  {
    Object localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    CheckBox localCheckBox;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new MosaicURLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131364541);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = new RelativeLayout.LayoutParams(S, T);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364529);
      ((RelativeLayout.LayoutParams)localObject).topMargin = U;
      if (this.X == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if ((localCheckBox != null) && (localCheckBox.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(25.0F, getContext().getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        }
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.Y);
      addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
    }
    else
    {
      localObject = (RelativeLayout.LayoutParams)((URLImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364529);
      if (this.X == 1)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
        localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if ((localCheckBox != null) && (localCheckBox.getVisibility() != 8)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(25.0F, getContext().getResources());
        } else {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        }
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.Y);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
    paramDrawable = AIOLongShotHelper.a();
    if ((paramDrawable != null) && (paramDrawable.c())) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localURLImageView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localURLImageView.setVisibility(i1);
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131364548);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130839401));
        int i1 = AIOUtils.b(16.0F, getContext().getResources());
        localObject = new RelativeLayout.LayoutParams(i1, i1);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(18.0F, getContext().getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131364521);
        if (this.X == 1)
        {
          ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(4.0F, getContext().getResources());
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131364521);
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(4.0F, getContext().getResources());
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364521);
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
        }
        addView(this.jdField_a_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
  }
  
  public void setRobotNextTipsView(boolean paramBoolean, Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView = new TroopRobotNextTipsView(getContext(), paramContext, paramQQAppInterface);
        paramContext = new RelativeLayout.LayoutParams(jdField_e_of_type_Int, -2);
        int i1 = o;
        int i2 = p;
        if (paramChatMessage.isSend())
        {
          i1 = p;
          i2 = o;
        }
        paramContext.addRule(3, 2131364521);
        paramContext.addRule(5, 2131364521);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setPadding(i1, 0, i2, 0);
        addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView, paramContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.a(paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setVisibility(0);
      return;
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
  }
  
  public void setStickerPressStatus(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (this.jdField_g_of_type_Boolean != this.jdField_h_of_type_Boolean) {
      invalidate();
    }
    this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTailMessage(paramBoolean, paramCharSequence, paramOnClickListener, true);
  }
  
  public void setTailMessage(boolean paramBoolean1, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_c_of_type_AndroidWidgetTextView.setId(2131364550);
        if (paramBoolean2) {
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130850064);
        } else {
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130841645);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(24, 0, 24, 0);
        Object localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364521);
        ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364521);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 0);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = jdField_i_of_type_Int;
        addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        localObject = new View(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
        localLayoutParams.addRule(3, 2131364550);
        localLayoutParams.addRule(5, 2131364521);
        addView((View)localObject, localLayoutParams);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramCharSequence != this.jdField_c_of_type_AndroidWidgetTextView.getTag()) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
      paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.X == 1) {
        paramCharSequence.leftMargin = k;
      } else {
        paramCharSequence.leftMargin = jdField_j_of_type_Int;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      return;
    }
    paramCharSequence = this.jdField_c_of_type_AndroidWidgetTextView;
    if (paramCharSequence != null) {
      paramCharSequence.setVisibility(8);
    }
  }
  
  public void setTimeStamp(boolean paramBoolean, ChatMessage paramChatMessage, ColorStateList paramColorStateList, CharSequence paramCharSequence)
  {
    if (paramChatMessage == null) {
      return;
    }
    long l1 = paramChatMessage.time;
    int i1 = 2131364529;
    if ((paramBoolean) && (l1 > 0L))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131364552);
        int i2 = AIOUtils.b(14.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i2, 0, i2, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = N;
        localLayoutParams.bottomMargin = O;
        localLayoutParams.addRule(14);
        addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      }
      if (paramColorStateList != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)this.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != l1) {
        if (paramCharSequence != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        }
        else
        {
          paramColorStateList = TimeFormatterUtils.a(getContext(), 3, l1 * 1000L);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColorStateList);
        }
      }
      paramColorStateList = this.jdField_b_of_type_AndroidWidgetTextView;
      if ((paramColorStateList == null) || (paramColorStateList.getVisibility() != 0)) {
        i1 = 2131364552;
      }
      d(i1);
      paramColorStateList = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      i1 = N;
      if (paramChatMessage.isFirstMsg) {
        i1 = N + P;
      }
      paramColorStateList.topMargin = i1;
      TimestampReporter.a(null, paramChatMessage);
      return;
    }
    paramChatMessage = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramChatMessage != null)
    {
      paramChatMessage.setVisibility(8);
      paramChatMessage = this.jdField_b_of_type_AndroidWidgetTextView;
      if ((paramChatMessage == null) || (paramChatMessage.getVisibility() != 0)) {
        i1 = 0;
      }
      d(i1);
    }
  }
  
  public void setUnread(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(8.0F, getContext().getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(-3.0F, getContext().getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131364521);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364521);
      addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850767);
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setOnClickListener(null);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */