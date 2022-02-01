import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class amiq
  extends anvi
{
  amiq(amik paramamik) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      amik.c(this.a);
    }
  }
  
  protected void onAddFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = (ArrayList)amik.a(this.a).clone();
    } while (localArrayList.isEmpty());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ajbn)localIterator.next();
      if ((localObject instanceof ajbi))
      {
        localObject = (ajbi)localObject;
        int i = ((ajbi)localObject).a.structMsg.msg.sub_type.get();
        localObject = ((ajbi)localObject).a.senderuin;
        if ((i == 13) && (paramString.equals(localObject))) {
          localIterator.remove();
        }
      }
    }
    amik.a(this.a, localArrayList);
    this.a.notifyDataSetChanged();
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void onSuspiciousGetUnreadNum(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSuspiciousGetUnreadNum " + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    if ((amik.a(this.a) != null) && (amik.a(this.a).getVisibility() == 0))
    {
      if ((paramBoolean) && (paramInt2 > 0)) {
        amik.a(this.a).setText(paramInt2 + "");
      }
    }
    else {
      return;
    }
    amik.a(this.a).setText("");
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (bpup.a(paramBundle.getInt("source_id")))) {
      amik.c(this.a);
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amiq
 * JD-Core Version:    0.7.0.1
 */