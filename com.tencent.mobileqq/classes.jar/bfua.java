import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.contentbox.MsgCardView;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import java.util.ArrayList;
import java.util.Iterator;

public class bfua
  extends BaseAdapter
{
  private bfub jdField_a_of_type_Bfub;
  private bfum jdField_a_of_type_Bfum;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ArrayList<MQMsg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bfua(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public MQMsg a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      MQMsg localMQMsg = (MQMsg)localIterator.next();
      Object localObject2;
      if (localObject1 == null) {
        localObject2 = localMQMsg;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localMQMsg;
        if (localObject1.pushTime > localMQMsg.pushTime) {
          localObject2 = localObject1;
        }
      }
    }
    return localObject1;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MQMsg)localIterator.next();
      if ((localObject != null) && (((MQMsg)localObject).pushTime == paramLong) && (((MQMsg)localObject).msgInteractData != null) && (((MQMsg)localObject).msgInteractData.likeCell != null) && (((MQMsg)localObject).msgInteractData.likeCell.liked != paramBoolean))
      {
        ((MQMsg)localObject).msgInteractData.likeCell.liked = paramBoolean;
        if (paramBoolean)
        {
          localObject = ((MQMsg)localObject).msgInteractData.likeCell;
          ((MQLikeCell)localObject).totalLike += 1;
        }
        else
        {
          localObject = ((MQMsg)localObject).msgInteractData.likeCell;
          ((MQLikeCell)localObject).totalLike -= 1;
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public void a(bfub parambfub)
  {
    this.jdField_a_of_type_Bfub = parambfub;
  }
  
  public void a(bfum parambfum)
  {
    this.jdField_a_of_type_Bfum = parambfum;
  }
  
  public void a(MQMsg paramMQMsg)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramMQMsg != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      MQMsg localMQMsg;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMQMsg = (MQMsg)localIterator.next();
      } while ((localMQMsg == null) || (localMQMsg.pushTime != paramMQMsg.pushTime));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, paramMQMsg);
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(ArrayList<MQMsg> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    MQMsg localMQMsg = a();
    if ((localMQMsg.msgBody.photolist == null) || (localMQMsg.msgBody.photolist.isEmpty())) {
      return this.jdField_a_of_type_JavaUtilArrayList.remove(localMQMsg);
    }
    return false;
  }
  
  public void b(ArrayList<MQMsg> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new MsgCardView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      paramView.setMsgOnClickListener(this.jdField_a_of_type_Bfum);
      paramView.setData(paramInt, (MQMsg)getItem(paramInt));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bfub != null) {
        this.jdField_a_of_type_Bfub.a(paramInt, paramView, paramViewGroup);
      }
      return paramView;
      ((MsgCardView)paramView).setMsgOnClickListener(this.jdField_a_of_type_Bfum);
      ((MsgCardView)paramView).setData(paramInt, (MQMsg)getItem(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfua
 * JD-Core Version:    0.7.0.1
 */