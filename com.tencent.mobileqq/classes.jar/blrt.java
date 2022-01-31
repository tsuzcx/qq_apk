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
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import dov.com.qq.im.capture.poi.FacePoiUI.2;
import dov.com.qq.im.capture.poi.FacePoiUI.4;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class blrt
  implements View.OnClickListener, bhqp, blrn
{
  long jdField_a_of_type_Long = 0L;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private blrk jdField_a_of_type_Blrk = new blrk(this);
  private blrw jdField_a_of_type_Blrw;
  bmwj jdField_a_of_type_Bmwj = null;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  View jdField_b_of_type_AndroidViewView = null;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  View c = null;
  View d = null;
  View e;
  
  public blrt()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      acmr localacmr = (acmr)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localacmr != null)
      {
        localacmr.a = false;
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
  
  public blrk a()
  {
    return this.jdField_a_of_type_Blrk;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368613));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376189);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131376213);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365761));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365762));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368659)).setText(alpo.a(2131704679));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372128));
      b();
      c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new blru(this));
      this.jdField_a_of_type_Bmwj = new bmwj(this.e.getContext());
      this.jdField_a_of_type_Bmwj.a(this.jdField_a_of_type_Blrk.a(), this.jdField_a_of_type_Blrk.a());
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bmwj);
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
        this.e.getContext().getString(2131718298);
        return;
        this.e.getContext().getString(2131718299);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          QQToast.a(this.e.getContext(), paramVarArgs[0], 1).a();
        }
      } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0));
      a(false, false);
      return;
    case 2: 
      this.e.getContext().getString(2131718300);
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
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.e.findViewById(2131373798));
  }
  
  public void a(blrw paramblrw)
  {
    this.jdField_a_of_type_Blrw = paramblrw;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131375536);
    if (paramBoolean)
    {
      localTextView.setText(2131720332);
      return;
    }
    localTextView.setText(2131720327);
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
      if (this.jdField_a_of_type_Bmwj != null)
      {
        this.jdField_a_of_type_Bmwj.a(paramArrayList, paramTroopBarPOI);
        this.jdField_a_of_type_Bmwj.notifyDataSetChanged();
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.e.getContext()).inflate(2131559511, null, false));
    }
    acmr localacmr = new acmr();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localacmr);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new blrv(this));
  }
  
  protected void c()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.e.getContext()).inflate(2131559511, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131375534);
      TextView localTextView1 = (TextView)this.d.findViewById(2131375536);
      TextView localTextView2 = (TextView)this.d.findViewById(2131375542);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131375537);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131720327);
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
    if (this.jdField_a_of_type_Bmwj != null)
    {
      this.jdField_a_of_type_Bmwj.a(this.jdField_a_of_type_Blrk.a(), this.jdField_a_of_type_Blrk.a());
      this.jdField_a_of_type_Bmwj.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368613: 
    case 2131376189: 
    case 2131376213: 
      do
      {
        return;
        this.jdField_a_of_type_Blrk.c();
        if (this.jdField_a_of_type_Blrw != null)
        {
          this.jdField_a_of_type_Blrw.ba_();
          return;
        }
        d();
        return;
      } while (this.jdField_a_of_type_Blrw == null);
      this.jdField_a_of_type_Blrw.b();
      return;
    }
    this.jdField_a_of_type_Blrk.a();
    a(false, true);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Blrk.a(paramInt)) || (this.jdField_a_of_type_Bmwj == null)) {
      return;
    }
    paramView = (TroopBarPOI)this.jdField_a_of_type_Blrk.a().get(paramInt);
    this.jdField_a_of_type_Blrk.a(paramView);
    e();
    bmjj localbmjj = this.jdField_a_of_type_Blrk.a();
    if (paramView != null) {
      if (TextUtils.isEmpty(paramView.c))
      {
        paramAdapterView = paramView.d;
        a(1, new String[] { paramAdapterView });
        if (localbmjj != null) {
          localbmjj.a(paramView);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Blrw == null) {
        break label150;
      }
      this.jdField_a_of_type_Blrw.c();
      return;
      paramAdapterView = paramView.c;
      break;
      a(0, new String[0]);
      if (localbmjj != null) {
        localbmjj.a(null);
      }
    }
    label150:
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrt
 * JD-Core Version:    0.7.0.1
 */