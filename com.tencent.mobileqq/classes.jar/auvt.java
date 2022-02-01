import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auvt
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  public int a;
  public auvm a;
  auvu a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  public MessageForArkFlashChat a;
  public FlashChatItem a;
  public int b;
  int c;
  
  public auvt(View paramView, auvu paramauvu, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = null;
    if (paramauvu != null) {
      this.jdField_a_of_type_Auvu = paramauvu;
    }
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362928));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370289));
    this.itemView.setOnClickListener(this);
    this.itemView.setOnTouchListener(paramauvu);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Auvu != null) {
      this.jdField_a_of_type_Auvu.a(paramView, getPosition(), this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Auvu != null)
    {
      this.jdField_a_of_type_Auvu.b(paramView, getPosition(), this.c);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvt
 * JD-Core Version:    0.7.0.1
 */