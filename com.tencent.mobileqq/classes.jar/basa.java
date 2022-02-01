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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel.4;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class basa
  extends barr<XListView>
  implements Handler.Callback
{
  protected aliq a;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected basf a;
  public bjmp a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new base(this);
  protected XListView a;
  public List<basn> a;
  protected int b;
  private TextView b;
  protected boolean b;
  private TextView c;
  private TextView d;
  
  public basa(int paramInt)
  {
    super(paramInt);
  }
  
  public basa(int paramInt, basf parambasf)
  {
    super(paramInt);
    this.jdField_a_of_type_Basf = parambasf;
  }
  
  private int a(List<basn> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (((SearchHistory)((basn)this.jdField_a_of_type_JavaUtilList.get(i)).a()).getId() == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private List<basn> a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (anap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((anap)localObject).a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new barv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSearchHistory));
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
    anap localanap = (anap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((localanap == null) || (paramSearchHistory == null)) {
      return false;
    }
    return localanap.b(paramSearchHistory);
  }
  
  private void e()
  {
    ThreadManager.postImmediately(new HistorySearchEntryModel.4(this), null, true);
  }
  
  public XListView a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjmp = new bjmp(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562954, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    paramContext = new AbsListView.LayoutParams(-1, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 7.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramContext);
    paramContext = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562741, null);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363681));
    this.c = ((TextView)paramContext.findViewById(2131363682));
    this.d = ((TextView)paramContext.findViewById(2131363683));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850155);
    this.jdField_a_of_type_Aliq = new aliq(paramQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetXListView, null, new basb(this), new basc(this), false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new basd(this));
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aliq);
    e();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aliq != null) {
      this.jdField_a_of_type_Aliq.c();
    }
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (this.jdField_a_of_type_Aliq == null)) {
      return;
    }
    int k = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), 0);
    Object localObject = null;
    int i = 0;
    int j = 0;
    while (j < this.jdField_a_of_type_Aliq.getCount())
    {
      localObject = this.jdField_a_of_type_Aliq.getView(j, (View)localObject, this.jdField_a_of_type_ComTencentWidgetXListView);
      if (j == 0) {
        ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(k, -2));
      }
      ((View)localObject).measure(k, 0);
      i += ((View)localObject).getMeasuredHeight();
      j += 1;
    }
    j = i;
    if (this.jdField_a_of_type_Aliq.getCount() > 0) {
      j = i + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (this.jdField_a_of_type_ComTencentWidgetXListView.getDividerHeight() * (this.jdField_a_of_type_Aliq.getCount() - 1) + j);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_Aliq.a();
        this.jdField_a_of_type_Aliq.a(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            bbgk.a("home_page", "exp_history", new String[] { "" + this.jdField_a_of_type_JavaUtilList.size() });
            bbda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D18", 0, 0, null, null);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      if (this.jdField_a_of_type_Basf != null)
      {
        paramMessage = this.jdField_a_of_type_Basf;
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
      paramMessage = (SearchHistory)((basn)this.jdField_a_of_type_JavaUtilList.remove(i)).a();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
      bcef.b(null, "CliOper", "", "", "0X8007620", "0X8007620", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Aliq.a();
      this.jdField_a_of_type_Aliq.a(this.jdField_a_of_type_JavaUtilList);
      bbda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D1A", i, 0, null, null);
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
 * Qualified Name:     basa
 * JD-Core Version:    0.7.0.1
 */