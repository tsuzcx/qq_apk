import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.MsgCardView;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import java.util.ArrayList;
import java.util.Iterator;

public class bmyc
  extends BaseAdapter
{
  private bmwv jdField_a_of_type_Bmwv;
  private bmyd jdField_a_of_type_Bmyd;
  private bmyo jdField_a_of_type_Bmyo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ArrayList<MQMsg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public bmyc(BaseActivity paramBaseActivity)
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
  
  public void a(bmwv parambmwv, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Bmwv = parambmwv;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(bmyd parambmyd)
  {
    this.jdField_a_of_type_Bmyd = parambmyd;
  }
  
  public void a(bmyo parambmyo)
  {
    this.jdField_a_of_type_Bmyo = parambmyo;
  }
  
  public void a(MQMsg paramMQMsg)
  {
    int i;
    MQMsg localMQMsg;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramMQMsg != null))
    {
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label131;
      }
      localMQMsg = (MQMsg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localMQMsg == null) || (localMQMsg.pushTime != paramMQMsg.pushTime)) {
        break label86;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, paramMQMsg);
        if (this.jdField_a_of_type_Bmwv != null) {
          this.jdField_a_of_type_Bmwv.d();
        }
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        label86:
        i += 1;
        break;
        if (paramMQMsg != localMQMsg)
        {
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramMQMsg);
          if ((i == 0) && (this.jdField_a_of_type_Bmwv != null)) {
            this.jdField_a_of_type_Bmwv.d();
          }
        }
      }
      label131:
      localMQMsg = null;
      i = -1;
    }
  }
  
  public void a(ArrayList<MQMsg> paramArrayList)
  {
    if (this.jdField_a_of_type_Bmwv != null) {
      this.jdField_a_of_type_Bmwv.d();
    }
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
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    MQMsg localMQMsg = a();
    if ((localMQMsg.msgBody.photolist == null) || (localMQMsg.msgBody.photolist.isEmpty()))
    {
      boolean bool = this.jdField_a_of_type_JavaUtilArrayList.remove(localMQMsg);
      if ((bool) && (this.jdField_a_of_type_Bmwv != null)) {
        this.jdField_a_of_type_Bmwv.d();
      }
      return bool;
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
    int j = 0;
    int i;
    if (paramView == null)
    {
      paramView = new MsgCardView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      paramView.setMsgOnClickListener(this.jdField_a_of_type_Bmyo);
      paramView.setData(paramInt, (MQMsg)getItem(paramInt), this.c, this.b);
      if ((paramInt != 0) || (this.jdField_a_of_type_Bmwv == null)) {
        break label228;
      }
      boolean bool = this.jdField_a_of_type_Bmwv.a(((MsgCardView)paramView).a(), (MQMsg)getItem(paramInt));
      Object localObject = ((MsgCardView)paramView).a();
      if (!bool) {
        break label214;
      }
      i = 0;
      label109:
      ((TextView)localObject).setVisibility(i);
      localObject = ((MsgCardView)paramView).a();
      if (!bool) {
        break label221;
      }
      i = j;
      label134:
      ((LinearLayout)localObject).setVisibility(i);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bmyd != null) {
        this.jdField_a_of_type_Bmyd.a(paramInt, paramView, paramViewGroup);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      ((MsgCardView)paramView).setMsgOnClickListener(this.jdField_a_of_type_Bmyo);
      ((MsgCardView)paramView).setData(paramInt, (MQMsg)getItem(paramInt), this.c, this.b);
      break;
      label214:
      i = 8;
      break label109;
      label221:
      i = 8;
      break label134;
      label228:
      ((MsgCardView)paramView).a().setVisibility(8);
      ((MsgCardView)paramView).a().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyc
 * JD-Core Version:    0.7.0.1
 */