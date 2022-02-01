import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import dov.com.qq.im.capture.poi.FacePoiUI.2;
import dov.com.qq.im.capture.poi.FacePoiUI.4;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class bpre
  implements View.OnClickListener, bljm, bpqy
{
  long jdField_a_of_type_Long = 0L;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private bpqv jdField_a_of_type_Bpqv = new bpqv(this);
  private bprh jdField_a_of_type_Bprh;
  bqtw jdField_a_of_type_Bqtw = null;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  View jdField_b_of_type_AndroidViewView = null;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  View c = null;
  View d = null;
  View e;
  
  public bpre()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      ajss localajss = (ajss)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localajss != null)
      {
        localajss.a = false;
        new Handler(Looper.getMainLooper()).postDelayed(new FacePoiUI.4(this), 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public bpqv a()
  {
    return this.jdField_a_of_type_Bpqv;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369042));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377156);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131377184);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366050));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366051));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369088)).setText(anzj.a(2131703195));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372838));
      b();
      c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bprf(this));
      this.jdField_a_of_type_Bqtw = new bqtw(this.e.getContext());
      this.jdField_a_of_type_Bqtw.a(this.jdField_a_of_type_Bpqv.a(), this.jdField_a_of_type_Bpqv.a());
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bqtw);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt, String... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 3: 
      do
      {
        return;
        this.e.getContext().getString(2131716585);
        return;
        this.e.getContext().getString(2131716586);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          QQToast.a(this.e.getContext(), paramVarArgs[0], 1).a();
        }
      } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0));
      a(false, false);
      return;
    case 2: 
      this.e.getContext().getString(2131716587);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
    {
      if (TextUtils.isEmpty(paramVarArgs[0]))
      {
        a(3, new String[0]);
        return;
      }
      paramVarArgs = paramVarArgs[0];
      return;
    }
    a(0, new String[0]);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalStateException("FacePoiUI rootView can't be null");
    }
    this.e = paramView;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.e.findViewById(2131374688));
  }
  
  public void a(bprh parambprh)
  {
    this.jdField_a_of_type_Bprh = parambprh;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131376444);
    if (paramBoolean)
    {
      localTextView.setText(2131718369);
      return;
    }
    localTextView.setText(2131718364);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramBoolean1, paramBoolean2);
      return;
    }
    ThreadManager.getUIHandler().post(new FacePoiUI.2(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<TroopBarPOI> paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    if (paramBoolean1)
    {
      a(paramBoolean2);
      if (this.jdField_a_of_type_Bqtw != null)
      {
        this.jdField_a_of_type_Bqtw.a(paramArrayList, paramTroopBarPOI);
        this.jdField_a_of_type_Bqtw.notifyDataSetChanged();
        if (paramArrayList.isEmpty()) {
          a(false, false);
        }
      }
      else
      {
        if (paramTroopBarPOI == null) {
          break label100;
        }
        if (!TextUtils.isEmpty(paramTroopBarPOI.c)) {
          break label91;
        }
      }
      label91:
      for (paramArrayList = paramTroopBarPOI.d;; paramArrayList = paramTroopBarPOI.c)
      {
        a(1, new String[] { paramArrayList });
        return;
        a(true, false);
        break;
      }
      label100:
      a(0, new String[0]);
      return;
    }
    a(3, new String[0]);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.e.getContext()).inflate(2131559652, null, false));
    }
    ajss localajss = new ajss();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localajss);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new bprg(this));
  }
  
  protected void c()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.e.getContext()).inflate(2131559652, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131376442);
      TextView localTextView1 = (TextView)this.d.findViewById(2131376444);
      TextView localTextView2 = (TextView)this.d.findViewById(2131376450);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131376445);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131718364);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bqtw != null)
    {
      this.jdField_a_of_type_Bqtw.a(this.jdField_a_of_type_Bpqv.a(), this.jdField_a_of_type_Bpqv.a());
      this.jdField_a_of_type_Bqtw.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Bpqv.c();
      if (this.jdField_a_of_type_Bprh != null)
      {
        this.jdField_a_of_type_Bprh.aV_();
      }
      else
      {
        d();
        continue;
        if (this.jdField_a_of_type_Bprh != null)
        {
          this.jdField_a_of_type_Bprh.b();
          continue;
          this.jdField_a_of_type_Bpqv.a();
          a(false, true);
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Bpqv.a(paramInt)) || (this.jdField_a_of_type_Bqtw == null)) {
      return;
    }
    paramView = (TroopBarPOI)this.jdField_a_of_type_Bpqv.a().get(paramInt);
    this.jdField_a_of_type_Bpqv.a(paramView);
    e();
    bqgw localbqgw = this.jdField_a_of_type_Bpqv.a();
    if (paramView != null) {
      if (TextUtils.isEmpty(paramView.c))
      {
        paramAdapterView = paramView.d;
        a(1, new String[] { paramAdapterView });
        if (localbqgw != null) {
          localbqgw.a(paramView);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bprh == null) {
        break label150;
      }
      this.jdField_a_of_type_Bprh.c();
      return;
      paramAdapterView = paramView.c;
      break;
      a(0, new String[0]);
      if (localbqgw != null) {
        localbqgw.a(null);
      }
    }
    label150:
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpre
 * JD-Core Version:    0.7.0.1
 */