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

public class aqlo
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
  
  public aqlo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
      localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692813));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramMessageForFuDai.isGrabByMe()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692812));
      } else if (paramMessageForFuDai.isEmpty()) {
        localStringBuilder.append("，").append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692814));
      }
    }
  }
  
  private void a(aqlp paramaqlp)
  {
    aqlp.a(paramaqlp).setFilter(-1711276033);
    aqlp.c(paramaqlp).setVisibility(0);
    aqlp.d(paramaqlp).setVisibility(8);
    aqlp.a(paramaqlp).setImageResource(2130844416);
    aqlp.c(paramaqlp).setImageResource(2130844417);
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
  
  public acun a()
  {
    return new aqlp();
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramacun = (aqlp)paramacun;
    MessageForFuDai localMessageForFuDai = (MessageForFuDai)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560786, paramBaseChatItemLayout, false);
      aqlp.a(paramacun, paramChatMessage);
      paramChatMessage.setOnLongClickListener(paramacxn);
      paramChatMessage.setOnTouchListener(paramacxn);
      aqlp.a(paramacun).setOnClickListener(this);
      aqlp.a(paramacun).setOnTouchListener(paramacxn);
      aqlp.a(paramacun).setOnLongClickListener(paramacxn);
    }
    if (jdField_e_of_type_Boolean)
    {
      paramView = a(localMessageForFuDai);
      bawi.a(aqlp.a(paramacun), paramView, View.class.getName());
      paramChatMessage.setContentDescription(paramView);
    }
    aqlp.a(paramacun, localMessageForFuDai);
    if (TextUtils.isEmpty(localMessageForFuDai.aioTails))
    {
      aqlp.a(paramacun).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("FudaiItemBuilder", 2, "no logo res");
      }
      aqlp.b(paramacun).setVisibility(8);
      if (!localMessageForFuDai.isExpired()) {
        break label255;
      }
      a(paramacun);
      aqlp.b(paramacun).setVisibility(0);
      aqlp.b(paramacun).setText(2131692813);
    }
    for (;;)
    {
      if (!this.b.contains(Long.valueOf(localMessageForFuDai.uniseq)))
      {
        this.b.add(Long.valueOf(localMessageForFuDai.uniseq));
        a(localMessageForFuDai, 110);
      }
      return paramChatMessage;
      aqlp.a(paramacun).setVisibility(0);
      aqlp.a(paramacun).setText(localMessageForFuDai.aioTails);
      break;
      label255:
      if (localMessageForFuDai.isGrabByMe())
      {
        a(paramacun);
        aqlp.b(paramacun).setVisibility(8);
      }
      else if (localMessageForFuDai.isEmpty())
      {
        a(paramacun);
        aqlp.b(paramacun).setVisibility(0);
        aqlp.b(paramacun).setText(2131692814);
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bbet.a(paramChatMessage.issend)) {
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
    case 2131364985: 
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public boolean a(acun paramacun)
  {
    return paramacun instanceof aqlp;
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    paramView = actn.a(paramView);
    a(paramView, localbblr);
    aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbblr);
    super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
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
    paramView = (MessageForFuDai)((aqlp)actn.a(paramView)).a;
    a(paramView, 111);
    ((aqln)localBaseChatPie.a(2)).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlo
 * JD-Core Version:    0.7.0.1
 */