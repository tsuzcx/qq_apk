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

public class bkus
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements DatePicker.OnDateChangedListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private bkvb jdField_a_of_type_Bkvb;
  private WMEditItem jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem;
  private List<WMEditItem> jdField_a_of_type_JavaUtilList;
  
  public bkus(Activity paramActivity, List<WMElement> paramList)
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
    if (this.jdField_a_of_type_Bkvb != null) {
      this.jdField_a_of_type_Bkvb.a();
    }
  }
  
  private void a(WMElement paramWMElement, bkva parambkva)
  {
    bdfq localbdfq = new bdfq(this.jdField_a_of_type_AndroidWidgetEditText.getContext(), 2131755801);
    localbdfq.setContentView(2131558943);
    localbdfq.setTitle(alpo.a(2131717256));
    localbdfq.setMessage(alpo.a(2131717261));
    localbdfq.setNegativeButton(alpo.a(2131717257), new bkux(this));
    localbdfq.setPositiveButton(alpo.a(2131717258), new bkuy(this, parambkva, paramWMElement));
    localbdfq.setCanceledOnTouchOutside(false);
    localbdfq.show();
  }
  
  private void b(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setCustomSelectionActionModeCallback(new bkuz(this));
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
      if (this.jdField_a_of_type_Bkvb != null) {
        this.jdField_a_of_type_Bkvb.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_AndroidWidgetEditText);
      }
    }
    label83:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 1);
    } while (this.jdField_a_of_type_Bkvb == null);
    this.jdField_a_of_type_Bkvb.a();
  }
  
  public void a(bkvb parambkvb)
  {
    this.jdField_a_of_type_Bkvb = parambkvb;
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
    bkva localbkva = (bkva)paramViewHolder;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = localbkva.jdField_a_of_type_AndroidWidgetEditText;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem = ((WMEditItem)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (getItemCount() == 1) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
      }
    }
    if (paramInt == getItemCount() - 1) {
      localbkva.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    WMEditItem localWMEditItem = (WMEditItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localbkva.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bkut(this, paramInt, localbkva));
    if (localWMEditItem.itemType != WMEditItem.ITEM_TYPE_TEXT)
    {
      localbkva.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
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
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setText(paramViewHolder);
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bkuu(this, localbkva, localWMEditItem));
      b(localbkva.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    if ((localWMEditItem.value == null) || (localWMEditItem.value.equals("")))
    {
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setText(((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).getDefault());
      if ((LogicDataManager.getInstance().getEditableWMElement() == null) || (LogicDataManager.getInstance().getEditableWMElement().size() <= 0) || (!((WMElement)LogicDataManager.getInstance().getEditableWMElement().get(paramInt)).ischeckin)) {
        break label419;
      }
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      localbkva.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837642);
      localbkva.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bkuv(this, localbkva, localWMEditItem));
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bkuw(this, localbkva, localWMEditItem));
      return;
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setText(localWMEditItem.value);
      break;
      label419:
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      localbkva.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      localbkva.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      localbkva.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837640);
      localbkva.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new bkva(this, LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558488, paramViewGroup, false));
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    label82:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem != null))
    {
      localObject = new StringBuilder().append(paramInt1).append(alpo.a(2131717260));
      if (paramInt2 + 1 >= 10) {
        break label202;
      }
      paramDatePicker = "0";
      localObject = ((StringBuilder)localObject).append(paramDatePicker).append(paramInt2 + 1).append(alpo.a(2131717255));
      if (paramInt3 >= 10) {
        break label208;
      }
      paramDatePicker = "0";
      localObject = paramDatePicker + paramInt3 + alpo.a(2131717259);
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
 * Qualified Name:     bkus
 * JD-Core Version:    0.7.0.1
 */