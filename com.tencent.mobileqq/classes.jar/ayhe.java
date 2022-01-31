import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel.4;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayhe
  extends aygv<XListView>
  implements Handler.Callback
{
  protected akik a;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ayhj a;
  public bhsl a;
  private bhuw jdField_a_of_type_Bhuw = new ayhi(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  public List<ayhr> a;
  protected boolean a;
  protected int b;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public ayhe(int paramInt)
  {
    super(paramInt);
  }
  
  public ayhe(int paramInt, ayhj paramayhj)
  {
    super(paramInt);
    this.jdField_a_of_type_Ayhj = paramayhj;
  }
  
  private int a(List<ayhr> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (((SearchHistory)((ayhr)this.jdField_a_of_type_JavaUtilList.get(i)).a()).getId() == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private List<ayhr> a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (amcg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((amcg)localObject).a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new aygz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSearchHistory));
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("searchUtils", 2, "initSearchHistoryData() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private boolean a(SearchHistory paramSearchHistory)
  {
    amcg localamcg = (amcg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((localamcg == null) || (paramSearchHistory == null)) {
      return false;
    }
    return localamcg.a(paramSearchHistory);
  }
  
  private void e()
  {
    ThreadManager.postImmediately(new HistorySearchEntryModel.4(this), null, true);
  }
  
  public XListView a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhsl = new bhsl(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562800, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    paramContext = new AbsListView.LayoutParams(-1, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramContext);
    paramContext = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562590, null);
    this.b = ((TextView)paramContext.findViewById(2131363431));
    this.c = ((TextView)paramContext.findViewById(2131363432));
    this.d = ((TextView)paramContext.findViewById(2131363433));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849646);
    this.jdField_a_of_type_Akik = new akik(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetXListView, null, new ayhf(this), new ayhg(this), false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ayhh(this));
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akik);
    e();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Akik != null) {
      this.jdField_a_of_type_Akik.c();
    }
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (this.jdField_a_of_type_Akik == null)) {
      return;
    }
    int k = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), 0);
    Object localObject = null;
    int i = 0;
    int j = 0;
    while (j < this.jdField_a_of_type_Akik.getCount())
    {
      localObject = this.jdField_a_of_type_Akik.getView(j, (View)localObject, this.jdField_a_of_type_ComTencentWidgetXListView);
      if (j == 0) {
        ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(k, -2));
      }
      ((View)localObject).measure(k, 0);
      i += ((View)localObject).getMeasuredHeight();
      j += 1;
    }
    j = i;
    if (this.jdField_a_of_type_Akik.getCount() > 0) {
      j = i + xsm.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_ComTencentWidgetXListView.getDividerHeight() * (this.jdField_a_of_type_Akik.getCount() - 1) + j);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_Akik.a();
        this.jdField_a_of_type_Akik.a(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            ayvm.a("home_page", "exp_history", new String[] { "" + this.jdField_a_of_type_JavaUtilList.size() });
            aysc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D18", 0, 0, null, null);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.b.setVisibility(0);
        }
      }
      if (this.jdField_a_of_type_Ayhj != null)
      {
        paramMessage = this.jdField_a_of_type_Ayhj;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          paramMessage.a(i);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "load history data finish");
        }
        d();
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
    }
    while (paramMessage.what != 3) {
      for (;;)
      {
        return true;
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
    }
    long l = ((Long)paramMessage.obj).longValue();
    int i = a(this.jdField_a_of_type_JavaUtilList, l);
    if (i != -1)
    {
      paramMessage = (SearchHistory)((ayhr)this.jdField_a_of_type_JavaUtilList.remove(i)).a();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
      }
      if (paramMessage == null) {
        break label516;
      }
      if (paramMessage.type == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      label339:
      azqs.b(null, "CliOper", "", "", "0X8007620", "0X8007620", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Akik.a();
      this.jdField_a_of_type_Akik.a(this.jdField_a_of_type_JavaUtilList);
      aysc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D1A", i, 0, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("searchUtils", 2, "delete history data finish : troopUin = " + paramMessage.troopUin + "displayname = " + paramMessage.displayName);
      }
      for (;;)
      {
        d();
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        break;
        if ((paramMessage.type != 1) && (paramMessage.type != 3000)) {
          break label516;
        }
        i = 2;
        break label339;
        if (QLog.isColorLevel()) {
          QLog.d("searchUtils", 2, "delete history data error");
        }
      }
      label516:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhe
 * JD-Core Version:    0.7.0.1
 */