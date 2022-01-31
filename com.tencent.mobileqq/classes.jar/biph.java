import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.openapi.model.WMEditItem;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.model.WMLogic;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.7;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class biph
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DatePicker.OnDateChangedListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private bipq jdField_a_of_type_Bipq;
  private WMEditItem jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem;
  private List<WMEditItem> jdField_a_of_type_JavaUtilList;
  
  public biph(Activity paramActivity, List<WMElement> paramList)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int j;
    int i;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        paramActivity = (WMElement)paramList.next();
        j = WMEditItem.ITEM_TYPE_TEXT;
        i = j;
        if (paramActivity.logic != null)
        {
          i = j;
          if (paramActivity.logic.type != null)
          {
            if (!paramActivity.logic.type.equals("since")) {
              break label131;
            }
            i = WMEditItem.ITEM_TYPE_SINCE;
          }
        }
        label97:
        if (paramActivity.userValue != null) {
          paramActivity = paramActivity.userValue;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(new WMEditItem(paramActivity, i));
      break;
      label131:
      i = j;
      if (!paramActivity.logic.type.equals("countdown")) {
        break label97;
      }
      i = WMEditItem.ITEM_TYPE_COUNTDOWN;
      break label97;
      if (i == WMEditItem.ITEM_TYPE_TEXT) {
        paramActivity = paramActivity.curValue;
      } else if (paramActivity.logic != null) {
        paramActivity = paramActivity.logic.compare;
      } else {
        paramActivity = "";
      }
    }
  }
  
  private void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.postDelayed(new WatermarkEditListAdapter.7(this, paramEditText), 200L);
    }
  }
  
  private void a(EditText paramEditText, WMEditItem paramWMEditItem)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem = paramWMEditItem;
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    if (this.jdField_a_of_type_Bipq != null) {
      this.jdField_a_of_type_Bipq.a();
    }
  }
  
  private void a(WMElement paramWMElement, bipp parambipp)
  {
    bbgg localbbgg = new bbgg(this.jdField_a_of_type_AndroidWidgetEditText.getContext(), 2131755791);
    localbbgg.setContentView(2131558906);
    localbbgg.setTitle(ajyc.a(2131716873));
    localbbgg.setMessage(ajyc.a(2131716878));
    localbbgg.setNegativeButton(ajyc.a(2131716874), new bipm(this));
    localbbgg.setPositiveButton(ajyc.a(2131716875), new bipn(this, parambipp, paramWMElement));
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.show();
  }
  
  private void b(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setCustomSelectionActionModeCallback(new bipo(this));
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
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType == WMEditItem.ITEM_TYPE_TEXT) {
        break label83;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-12339461);
      if (this.jdField_a_of_type_Bipq != null) {
        this.jdField_a_of_type_Bipq.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_AndroidWidgetEditText);
      }
    }
    label83:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 1);
    } while (this.jdField_a_of_type_Bipq == null);
    this.jdField_a_of_type_Bipq.a();
  }
  
  public void a(bipq parambipq)
  {
    this.jdField_a_of_type_Bipq = parambipq;
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
    bipp localbipp = (bipp)paramViewHolder;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = localbipp.jdField_a_of_type_AndroidWidgetEditText;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem = ((WMEditItem)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (getItemCount() == 1) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      }
    }
    if (paramInt == getItemCount() - 1) {
      localbipp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    WMEditItem localWMEditItem = (WMEditItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localbipp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bipi(this, paramInt, localbipp));
    if (localWMEditItem.itemType != WMEditItem.ITEM_TYPE_TEXT)
    {
      localbipp.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      Object localObject = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      paramViewHolder = null;
      try
      {
        localObject = localSimpleDateFormat.format(((SimpleDateFormat)localObject).parse(localWMEditItem.value));
        paramViewHolder = (RecyclerView.ViewHolder)localObject;
      }
      catch (ParseException localParseException)
      {
        for (;;)
        {
          localParseException.printStackTrace();
        }
      }
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setText(paramViewHolder);
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bipj(this, localbipp, localWMEditItem));
      b(localbipp.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    if ((localWMEditItem.value == null) || (localWMEditItem.value.equals("")))
    {
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setText(((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).getDefault());
      if ((LogicDataManager.getInstance().getEditableWMElement() == null) || (LogicDataManager.getInstance().getEditableWMElement().size() <= 0) || (!((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).ischeckin)) {
        break label419;
      }
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      localbipp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837636);
      localbipp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bipk(this, localbipp, localWMEditItem));
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bipl(this, localbipp, localWMEditItem));
      return;
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setText(localWMEditItem.value);
      break;
      label419:
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      localbipp.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      localbipp.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      localbipp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837634);
      localbipp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new bipp(this, LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558486, paramViewGroup, false));
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    label82:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem != null))
    {
      localObject = new StringBuilder().append(paramInt1).append(ajyc.a(2131716877));
      if (paramInt2 + 1 >= 10) {
        break label202;
      }
      paramDatePicker = "0";
      localObject = ((StringBuilder)localObject).append(paramDatePicker).append(paramInt2 + 1).append(ajyc.a(2131716872));
      if (paramInt3 >= 10) {
        break label208;
      }
      paramDatePicker = "0";
      localObject = paramDatePicker + paramInt3 + ajyc.a(2131716876);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biph
 * JD-Core Version:    0.7.0.1
 */