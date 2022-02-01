import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.now.message.MessageReceivingAdapter;
import com.tencent.mobileqq.now.widget.DecoratorViewPager;
import com.tencent.mobileqq.now.widget.SimpleCircleIndicator;
import java.util.ArrayList;
import java.util.List;

public class aywc
  extends ayvh
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new aywd(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageReceivingAdapter jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter;
  private DecoratorViewPager jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager;
  private SimpleCircleIndicator jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator;
  private boolean jdField_a_of_type_Boolean;
  
  public aywc(FragmentActivity paramFragmentActivity, RecyclerView paramRecyclerView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFragmentActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new ainh(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int = 1008;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370772));
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager = ((DecoratorViewPager)paramView.findViewById(2131381075));
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setNestedpParent(paramRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter = new MessageReceivingAdapter(paramFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator = ((SimpleCircleIndicator)paramView.findViewById(2131364537));
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager);
    this.jdField_a_of_type_ComTencentMobileqqNowWidgetSimpleCircleIndicator.setMaxCount(3);
    b();
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bhsw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 3, paramChatMessage.time * 1000L, true));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)this.itemView.getLayoutParams();
    if (paramBoolean) {}
    for (int i = bdep.a(255.0F);; i = 0)
    {
      localLayoutParams.height = i;
      this.itemView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void b()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ayvd.a, 1008, -1L, true);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (localList != null)
    {
      i = localList.size() - 1;
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i);
        if (!TextUtils.isEmpty(ayvz.a(localChatMessage))) {
          localArrayList.add(localChatMessage);
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((localChatMessage instanceof MessageForArkApp)) {
            localArrayList.add(localChatMessage);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter.a(localArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter.getCount() > 0)
    {
      a(true);
      if (this.jdField_a_of_type_Int < localArrayList.size()) {}
      for (i = this.jdField_a_of_type_Int;; i = localArrayList.size() - 1)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter.a(i));
        this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.setCurrentItem(i);
        this.jdField_a_of_type_ComTencentMobileqqNowWidgetDecoratorViewPager.invalidate();
        return;
      }
    }
    a(false);
  }
  
  private void c()
  {
    Object localObject = aywr.a();
    if (localObject != null)
    {
      localObject = (aody)((AppInterface)localObject).getManager(56);
      if (localObject == null) {}
    }
    for (localObject = ((aody)localObject).a(ayvd.a);; localObject = null)
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatActivity.class));
      localBundle.putString("uin", ayvd.a);
      localBundle.putInt("uintype", 1008);
      if (localObject != null) {}
      for (localObject = ((AccountDetail)localObject).name;; localObject = "")
      {
        localBundle.putString("uinname", (String)localObject);
        localIntent.putExtras(localBundle);
        localIntent.setFlags(67108864);
        localIntent.putExtra("isforceRequestDetail", false);
        localIntent.putExtra("jump_from", 2);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
        return;
      }
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      b();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywc
 * JD-Core Version:    0.7.0.1
 */