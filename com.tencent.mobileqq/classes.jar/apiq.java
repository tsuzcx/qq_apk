import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.LabelTextView;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class apiq
  extends DialogFromBottom
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private float jdField_a_of_type_Float;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  apim jdField_a_of_type_Apim = new apit(this);
  private apiu jdField_a_of_type_Apiu;
  private apix jdField_a_of_type_Apix;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString;
  private List<aphw> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  protected apiq(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, List<aphw> paramList, apix paramapix)
  {
    super(paramContext, 2131755054);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Apix = paramapix;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<aphx> paramList)
  {
    paramLinearLayout.removeAllViews();
    int j = ViewUtils.dpToPx(12.0F);
    int k = ViewUtils.dpToPx(1.0F);
    int m = ViewUtils.dpToPx(8.0F);
    int n = ViewUtils.dpToPx(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(ViewUtils.dpToPx(12));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    aphx localaphx;
    if (i < i1)
    {
      localaphx = (aphx)paramList.get(i);
      if ((localaphx == null) || (TextUtils.isEmpty(localaphx.jdField_a_of_type_JavaLangString))) {
        break label313;
      }
      int i2 = (int)(((Paint)localObject).measureText(localaphx.jdField_a_of_type_JavaLangString) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(localaphx);
        paramInt = paramInt - i2 - n;
      }
    }
    label313:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localaphx);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (aphx)localArrayList.get(paramInt);
        paramList = new LabelTextView(getContext());
        paramList.setParam(Color.parseColor(((aphx)localObject).b), Color.parseColor(((aphx)localObject).c), j);
        paramList.setTextSize(12);
        paramList.setText(((aphx)localObject).jdField_a_of_type_JavaLangString);
        paramList.setPadding(m, k, m, k);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (paramInt != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        paramLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
        paramInt += 1;
      }
      return localArrayList.size();
    }
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView == null) || (paramRecyclerView.getVisibility() != 0) || (!paramRecyclerView.isShown()) || (!paramRecyclerView.getGlobalVisibleRect(new Rect()))) {}
    for (;;)
    {
      return;
      try
      {
        int[] arrayOfInt = new int[2];
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
        arrayOfInt[0] = paramRecyclerView.findFirstVisibleItemPosition();
        arrayOfInt[1] = paramRecyclerView.findLastVisibleItemPosition();
        if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
          continue;
        }
        int i = arrayOfInt[0];
        while (i <= arrayOfInt[1])
        {
          if ((this.jdField_a_of_type_JavaUtilList != null) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null) && (!TextUtils.isEmpty(((aphw)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaUtilList.contains(((aphw)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            this.jdField_b_of_type_JavaUtilList.add(((aphw)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
            bcef.b(null, "dc00898", "", "", "0X800B32C", "0X800B32C", apil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, ((aphw)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString, i + "", "", "");
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Apim);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
    {
      if (this.jdField_a_of_type_Apix != null) {
        this.jdField_a_of_type_Apix.a(paramBoolean, this.jdField_a_of_type_JavaLangString);
      }
      bcef.b(null, "dc00898", "", "", "0X800B32F", "0X800B32F", apil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
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
      if (this.jdField_a_of_type_Apix != null)
      {
        this.jdField_a_of_type_Apix.c();
        continue;
        dismiss();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 8;
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -1;
    paramBundle.gravity = 81;
    int i = DisplayHelper.getScreenWidth(getContext());
    int k = DisplayHelper.getScreenHeight(getContext());
    if (i < k)
    {
      paramBundle.width = i;
      getWindow().setAttributes(paramBundle);
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131558764, null));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364122);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364131));
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramBundle.topMargin = (ImmersiveUtils.getStatusBarHeight(getContext()) + getContext().getResources().getDimensionPixelSize(2131299076));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBundle);
      if (!bool) {
        break label534;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(getContext().getResources().getDrawable(2130838989));
      label226:
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364130));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new apir(this));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364132));
      paramBundle = new LinearLayoutManager(getContext(), 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
      this.jdField_a_of_type_Apiu = new apiu(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Apiu);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new apis(this));
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364123);
      if (!this.jdField_a_of_type_Boolean) {
        break label557;
      }
      i = 0;
      label364:
      localView.setVisibility(i);
      if (!bool) {
        break label563;
      }
      paramBundle = "#3D3D41";
      label379:
      localView.setBackgroundColor(Color.parseColor(paramBundle));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364133));
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      i = j;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      if (this.jdField_a_of_type_Boolean) {
        if (!bool) {
          break label570;
        }
      }
    }
    label534:
    label557:
    label563:
    label570:
    for (paramBundle = "#282828";; paramBundle = "#FFFFFF")
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundColor(Color.parseColor(paramBundle));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
      bcef.b(null, "dc00898", "", "", "0X800B32E", "0X800B32E", apil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString), 0, "", "", "", "");
      setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
      return;
      i = k;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(getContext().getResources().getDrawable(2130838988));
      break label226;
      i = 8;
      break label364;
      paramBundle = "#EBEDF5";
      break label379;
    }
  }
  
  public void show()
  {
    super.show();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Apim);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apiq
 * JD-Core Version:    0.7.0.1
 */