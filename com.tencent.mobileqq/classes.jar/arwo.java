import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatItem;

public class arwo
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  public int a;
  public arwh a;
  arwp a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  public MessageForArkFlashChat a;
  public FlashChatItem a;
  public int b;
  int c;
  
  public arwo(View paramView, arwp paramarwp, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = null;
    if (paramarwp != null) {
      this.jdField_a_of_type_Arwp = paramarwp;
    }
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362798));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131369757));
    this.itemView.setOnClickListener(this);
    this.itemView.setOnTouchListener(paramarwp);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Arwp != null) {
      this.jdField_a_of_type_Arwp.a(paramView, getPosition(), this.c);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Arwp != null)
    {
      this.jdField_a_of_type_Arwp.b(paramView, getPosition(), this.c);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwo
 * JD-Core Version:    0.7.0.1
 */