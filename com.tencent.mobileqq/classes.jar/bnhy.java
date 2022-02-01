import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.model.WMLogic;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.8;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bnhy
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DatePicker.OnDateChangedListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bnii jdField_a_of_type_Bnii;
  private WMEditItem jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem;
  private String jdField_a_of_type_JavaLangString;
  private List<WMEditItem> jdField_a_of_type_JavaUtilList;
  
  public bnhy(Activity paramActivity, List<WMElement> paramList)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        WMElement localWMElement = (WMElement)paramList.next();
        int j = WMEditItem.ITEM_TYPE_TEXT;
        int i = j;
        if (localWMElement.logic != null)
        {
          i = j;
          if (localWMElement.logic.type != null)
          {
            if (!localWMElement.logic.type.equals("since")) {
              break label170;
            }
            i = WMEditItem.ITEM_TYPE_SINCE;
          }
        }
        label101:
        if (("[location]".equals(localWMElement.fmtstr)) || ("[City]".equals(localWMElement.fmtstr))) {
          i = WMEditItem.ITEM_TYPE_ADDRESS;
        }
        paramActivity = "";
        if (localWMElement.userValue != null) {
          paramActivity = localWMElement.userValue;
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilList.add(new WMEditItem(paramActivity, i));
          break;
          label170:
          i = j;
          if (!localWMElement.logic.type.equals("countdown")) {
            break label101;
          }
          i = WMEditItem.ITEM_TYPE_COUNTDOWN;
          break label101;
          if (i == WMEditItem.ITEM_TYPE_TEXT) {
            paramActivity = localWMElement.curValue;
          }
          if (i == WMEditItem.ITEM_TYPE_ADDRESS) {
            paramActivity = localWMElement.curValue;
          } else if (localWMElement.logic != null) {
            paramActivity = localWMElement.logic.compare;
          }
        }
      }
    }
  }
  
  private void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.postDelayed(new WatermarkEditListAdapter.8(this, paramEditText), 200L);
    }
  }
  
  private void a(EditText paramEditText, WMEditItem paramWMEditItem)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem = paramWMEditItem;
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    if (this.jdField_a_of_type_Bnii != null) {
      this.jdField_a_of_type_Bnii.a();
    }
  }
  
  private void a(WMElement paramWMElement, bnih parambnih)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidWidgetEditText.getContext(), 2131755829);
    localQQCustomDialog.setContentView(2131559043);
    localQQCustomDialog.setTitle(anvx.a(2131716236));
    localQQCustomDialog.setMessage(anvx.a(2131716241));
    localQQCustomDialog.setNegativeButton(anvx.a(2131716237), new bnie(this));
    localQQCustomDialog.setPositiveButton(anvx.a(2131716238), new bnif(this, parambnih, paramWMElement));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  private void b(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setCustomSelectionActionModeCallback(new bnig(this));
    }
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((WMEditItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).value;
    }
    return "";
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem != null))
    {
      if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType != WMEditItem.ITEM_TYPE_SINCE) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType != WMEditItem.ITEM_TYPE_COUNTDOWN)) {
        break label142;
      }
      if (!bnlb.j(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
        break label119;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165269));
      if (this.jdField_a_of_type_Bnii != null) {
        this.jdField_a_of_type_Bnii.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_AndroidWidgetEditText);
      }
    }
    label119:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165270));
        break;
      } while (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType != WMEditItem.ITEM_TYPE_TEXT);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 1);
    } while (this.jdField_a_of_type_Bnii == null);
    label142:
    this.jdField_a_of_type_Bnii.a();
  }
  
  public void a(bnii parambnii)
  {
    this.jdField_a_of_type_Bnii = parambnii;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    bnih localbnih = (bnih)paramViewHolder;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = localbnih.jdField_a_of_type_AndroidWidgetEditText;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem = ((WMEditItem)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (getItemCount() == 1) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      }
    }
    if (paramInt == getItemCount() - 1) {
      localbnih.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    WMEditItem localWMEditItem = (WMEditItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localbnih.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bnhz(this, paramInt, localbnih));
    if (localWMEditItem.itemType == WMEditItem.ITEM_TYPE_ADDRESS)
    {
      localbnih.b.setVisibility(8);
      localbnih.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_JavaLangString = localWMEditItem.value;
      this.jdField_a_of_type_AndroidWidgetTextView = localbnih.jdField_a_of_type_AndroidWidgetTextView;
      if (localbnih.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localbnih.jdField_a_of_type_AndroidWidgetTextView.setText(localWMEditItem.value);
        localbnih.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bnia(this));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (localWMEditItem.itemType == WMEditItem.ITEM_TYPE_TEXT) {
        break label359;
      }
      localbnih.b.setVisibility(0);
      localbnih.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localbnih.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      Object localObject1 = null;
      try
      {
        localObject2 = localSimpleDateFormat.format(((SimpleDateFormat)localObject2).parse(localWMEditItem.value));
        localObject1 = localObject2;
      }
      catch (ParseException localParseException)
      {
        for (;;)
        {
          localParseException.printStackTrace();
        }
      }
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setText(localObject1);
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bnib(this, localbnih, localWMEditItem));
      b(localbnih.jdField_a_of_type_AndroidWidgetEditText);
    }
    label359:
    localbnih.b.setVisibility(0);
    localbnih.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if ((localWMEditItem.value == null) || (localWMEditItem.value.equals("")))
    {
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setText(((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).getDefault());
      label425:
      if ((LogicDataManager.getInstance().getEditableWMElement() == null) || (LogicDataManager.getInstance().getEditableWMElement().size() <= 0) || (!((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).ischeckin)) {
        break label566;
      }
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      localbnih.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837710);
      localbnih.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bnic(this, localbnih, localWMEditItem));
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bnid(this, localbnih, localWMEditItem));
      break;
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setText(localWMEditItem.value);
      break label425;
      label566:
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      localbnih.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      localbnih.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      localbnih.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837708);
      localbnih.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new bnih(this, LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558511, paramViewGroup, false));
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    label82:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem != null))
    {
      localObject = new StringBuilder().append(paramInt1).append(anvx.a(2131716240));
      if (paramInt2 + 1 >= 10) {
        break label202;
      }
      paramDatePicker = "0";
      localObject = ((StringBuilder)localObject).append(paramDatePicker).append(paramInt2 + 1).append(anvx.a(2131716235));
      if (paramInt3 >= 10) {
        break label208;
      }
      paramDatePicker = "0";
      localObject = paramDatePicker + paramInt3 + anvx.a(2131716239);
      localStringBuilder = new StringBuilder().append(paramInt1).append("-");
      if (paramInt2 + 1 >= 10) {
        break label214;
      }
      paramDatePicker = "0";
      label138:
      localStringBuilder = localStringBuilder.append(paramDatePicker).append(paramInt2 + 1).append("-");
      if (paramInt3 >= 10) {
        break label220;
      }
    }
    label202:
    label208:
    label214:
    label220:
    for (paramDatePicker = "0";; paramDatePicker = "")
    {
      paramDatePicker = paramDatePicker + paramInt3;
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetEditText.setTag(paramDatePicker);
      return;
      paramDatePicker = "";
      break;
      paramDatePicker = "";
      break label82;
      paramDatePicker = "";
      break label138;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhy
 * JD-Core Version:    0.7.0.1
 */