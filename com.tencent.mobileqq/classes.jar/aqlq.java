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

public class aqlq
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
  
  public aqlq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramQQAppInterface = paramContext.getResources();
    this.c = paramQQAppInterface.getDimensionPixelSize(2131296987);
    this.d = paramQQAppInterface.getDimensionPixelSize(2131296986);
    this.jdField_e_of_type_Int = paramQQAppInterface.getDimensionPixelSize(2131296991);
    this.f = paramQQAppInterface.getDimensionPixelSize(2131296990);
    this.g = paramQQAppInterface.getDimensionPixelSize(2131296993);
    this.h = paramQQAppInterface.getDimensionPixelSize(2131296992);
    this.i = paramQQAppInterface.getDimensionPixelSize(2131296989);
    this.j = paramQQAppInterface.getDimensionPixelSize(2131296988);
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
      localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692814));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramMessageForFuDai.isGrabByMe()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692813));
      } else if (paramMessageForFuDai.isEmpty()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692815));
      }
    }
  }
  
  private void a(aqlr paramaqlr)
  {
    aqlr.a(paramaqlr).setFilter(-1711276033);
    aqlr.c(paramaqlr).setVisibility(0);
    aqlr.d(paramaqlr).setVisibility(8);
    aqlr.a(paramaqlr).setImageResource(2130844417);
    aqlr.c(paramaqlr).setImageResource(2130844418);
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
  
  public acuj a()
  {
    return new aqlr();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramacuj = (aqlr)paramacuj;
    MessageForFuDai localMessageForFuDai = (MessageForFuDai)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560785, paramBaseChatItemLayout, false);
      aqlr.a(paramacuj, paramChatMessage);
      paramChatMessage.setOnLongClickListener(paramacxj);
      paramChatMessage.setOnTouchListener(paramacxj);
      aqlr.a(paramacuj).setOnClickListener(this);
      aqlr.a(paramacuj).setOnTouchListener(paramacxj);
      aqlr.a(paramacuj).setOnLongClickListener(paramacxj);
    }
    if (jdField_e_of_type_Boolean)
    {
      paramView = a(localMessageForFuDai);
      baww.a(aqlr.a(paramacuj), paramView, View.class.getName());
      paramChatMessage.setContentDescription(paramView);
    }
    aqlr.a(paramacuj, localMessageForFuDai);
    if (TextUtils.isEmpty(localMessageForFuDai.aioTails))
    {
      aqlr.a(paramacuj).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("FudaiItemBuilder", 2, "no logo res");
      }
      aqlr.b(paramacuj).setVisibility(8);
      if (!localMessageForFuDai.isExpired()) {
        break label255;
      }
      a(paramacuj);
      aqlr.b(paramacuj).setVisibility(0);
      aqlr.b(paramacuj).setText(2131692814);
    }
    for (;;)
    {
      if (!this.b.contains(Long.valueOf(localMessageForFuDai.uniseq)))
      {
        this.b.add(Long.valueOf(localMessageForFuDai.uniseq));
        a(localMessageForFuDai, 110);
      }
      return paramChatMessage;
      aqlr.a(paramacuj).setVisibility(0);
      aqlr.a(paramacuj).setText(localMessageForFuDai.aioTails);
      break;
      label255:
      if (localMessageForFuDai.isGrabByMe())
      {
        a(paramacuj);
        aqlr.b(paramacuj).setVisibility(8);
      }
      else if (localMessageForFuDai.isEmpty())
      {
        a(paramacuj);
        aqlr.b(paramacuj).setVisibility(0);
        aqlr.b(paramacuj).setText(2131692815);
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bbfh.a(paramChatMessage.issend)) {
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
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public boolean a(acuj paramacuj)
  {
    return paramacuj instanceof aqlr;
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    a(paramView, localbbmf);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbbmf);
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
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
    paramView = (MessageForFuDai)((aqlr)actj.a(paramView)).a;
    a(paramView, 111);
    ((aqlp)localBaseChatPie.a(2)).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlq
 * JD-Core Version:    0.7.0.1
 */