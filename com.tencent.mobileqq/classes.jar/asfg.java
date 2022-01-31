import android.content.Context;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.widget.FilterRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class asfg
  extends BaseBubbleBuilder
{
  @Nullable
  private static ArraySet<WeakReference<CustomFrameAnimationDrawable>> jdField_a_of_type_AndroidSupportV4UtilArraySet;
  private static final SparseArrayCompat<String[]> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final ArrayMap<String, Boolean> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private ArraySet<Long> b = new ArraySet();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public asfg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramQQAppInterface = paramContext.getResources();
    this.c = paramQQAppInterface.getDimensionPixelSize(2131297004);
    this.d = paramQQAppInterface.getDimensionPixelSize(2131297003);
    this.jdField_e_of_type_Int = paramQQAppInterface.getDimensionPixelSize(2131297008);
    this.f = paramQQAppInterface.getDimensionPixelSize(2131297007);
    this.g = paramQQAppInterface.getDimensionPixelSize(2131297010);
    this.h = paramQQAppInterface.getDimensionPixelSize(2131297009);
    this.i = paramQQAppInterface.getDimensionPixelSize(2131297006);
    this.j = paramQQAppInterface.getDimensionPixelSize(2131297005);
  }
  
  @Nullable
  private BaseChatPie a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localChatFragment == null) {
        return null;
      }
      return localChatFragment.a();
    }
    return null;
  }
  
  private String a(MessageForFuDai paramMessageForFuDai)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForFuDai.aioTails);
    if (paramMessageForFuDai.isExpired()) {
      localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692896));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramMessageForFuDai.isGrabByMe()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692895));
      } else if (paramMessageForFuDai.isEmpty()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692897));
      }
    }
  }
  
  private void a(asfh paramasfh)
  {
    asfh.a(paramasfh).setFilter(-1711276033);
    asfh.c(paramasfh).setVisibility(0);
    asfh.d(paramasfh).setVisibility(8);
    asfh.a(paramasfh).setImageResource(2130844779);
    asfh.c(paramasfh).setImageResource(2130844780);
  }
  
  private void a(MessageForFuDai paramMessageForFuDai, int paramInt) {}
  
  public static void e()
  {
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = jdField_a_of_type_AndroidSupportV4UtilArraySet.iterator();
      while (localIterator.hasNext())
      {
        CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)localIterator.next()).get();
        if (localCustomFrameAnimationDrawable != null) {
          localCustomFrameAnimationDrawable.e();
        }
      }
    }
  }
  
  public static void f()
  {
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = jdField_a_of_type_AndroidSupportV4UtilArraySet.iterator();
      while (localIterator.hasNext())
      {
        CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)localIterator.next()).get();
        if (localCustomFrameAnimationDrawable != null) {
          localCustomFrameAnimationDrawable.d();
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new asfh();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    paramaelt = (asfh)paramaelt;
    MessageForFuDai localMessageForFuDai = (MessageForFuDai)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560968, paramBaseChatItemLayout, false);
      asfh.a(paramaelt, paramChatMessage);
      paramChatMessage.setOnLongClickListener(paramaeov);
      paramChatMessage.setOnTouchListener(paramaeov);
      asfh.a(paramaelt).setOnClickListener(this);
      asfh.a(paramaelt).setOnTouchListener(paramaeov);
      asfh.a(paramaelt).setOnLongClickListener(paramaeov);
    }
    if (jdField_e_of_type_Boolean)
    {
      paramView = a(localMessageForFuDai);
      bcvq.a(asfh.a(paramaelt), paramView, View.class.getName());
      paramChatMessage.setContentDescription(paramView);
    }
    asfh.a(paramaelt, localMessageForFuDai);
    if (TextUtils.isEmpty(localMessageForFuDai.aioTails))
    {
      asfh.a(paramaelt).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("FudaiItemBuilder", 2, "no logo res");
      }
      asfh.b(paramaelt).setVisibility(8);
      if (!localMessageForFuDai.isExpired()) {
        break label255;
      }
      a(paramaelt);
      asfh.b(paramaelt).setVisibility(0);
      asfh.b(paramaelt).setText(2131692896);
    }
    for (;;)
    {
      if (!this.b.contains(Long.valueOf(localMessageForFuDai.uniseq)))
      {
        this.b.add(Long.valueOf(localMessageForFuDai.uniseq));
        a(localMessageForFuDai, 110);
      }
      return paramChatMessage;
      asfh.a(paramaelt).setVisibility(0);
      asfh.a(paramaelt).setText(localMessageForFuDai.aioTails);
      break;
      label255:
      if (localMessageForFuDai.isGrabByMe())
      {
        a(paramaelt);
        asfh.b(paramaelt).setVisibility(8);
      }
      else if (localMessageForFuDai.isEmpty())
      {
        a(paramaelt);
        asfh.b(paramaelt).setVisibility(0);
        asfh.b(paramaelt).setText(2131692897);
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bdec.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append(a((MessageForFuDai)paramChatMessage));
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet != null) {
      jdField_a_of_type_AndroidSupportV4UtilArraySet.clear();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365069: 
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public boolean a(aelt paramaelt)
  {
    return paramaelt instanceof asfh;
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = aekt.a(paramView);
    a(paramView, localbdkz);
    acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbdkz);
    super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = a();
    } while (localBaseChatPie == null);
    paramView = (MessageForFuDai)((asfh)aekt.a(paramView)).a;
    a(paramView, 111);
    ((asff)localBaseChatPie.a(2)).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfg
 * JD-Core Version:    0.7.0.1
 */