import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatItem;

public class apgy
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  public int a;
  public apgr a;
  apgz a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  public MessageForArkFlashChat a;
  public FlashChatItem a;
  public int b;
  int c;
  
  public apgy(View paramView, apgz paramapgz, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = null;
    if (paramapgz != null) {
      this.jdField_a_of_type_Apgz = paramapgz;
    }
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131297229));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131303802));
    this.itemView.setOnClickListener(this);
    this.itemView.setOnTouchListener(paramapgz);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Apgz != null) {
      this.jdField_a_of_type_Apgz.a(paramView, getPosition(), this.c);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Apgz != null)
    {
      this.jdField_a_of_type_Apgz.b(paramView, getPosition(), this.c);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apgy
 * JD-Core Version:    0.7.0.1
 */