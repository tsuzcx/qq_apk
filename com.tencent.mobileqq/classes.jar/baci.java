import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class baci
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private back jdField_a_of_type_Back;
  private String jdField_a_of_type_JavaLangString;
  private List<bact> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public baci(Context paramContext, String paramString, back paramback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Back = paramback;
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  protected String a(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 1000000L)
    {
      String str2 = String.format("%.2f", new Object[] { Double.valueOf((float)paramLong / 10000.0F - 0.005D) });
      String str1 = str2;
      if (str2.length() > 2)
      {
        str1 = str2;
        if (str2.substring(str2.length() - 2).equals("00")) {
          str1 = str2.substring(0, str2.length() - 3);
        }
      }
      return str1 + this.jdField_a_of_type_AndroidContentContext.getString(2131699030);
    }
    return String.valueOf(paramLong / 10000L) + this.jdField_a_of_type_AndroidContentContext.getString(2131699030);
  }
  
  protected void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      bact localbact = (bact)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      bghc.a(this.jdField_a_of_type_AndroidContentContext, localbact.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      bdla.b(null, "dc00898", "", "", "0X800B598", "0X800B598", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Back != null) {
        this.jdField_a_of_type_Back.a();
      }
    }
  }
  
  public void a(List<bact> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  protected String b(long paramLong)
  {
    if (paramLong <= 0L) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131699087);
    }
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699026), new Object[] { String.valueOf(paramLong) });
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    bacl localbacl = (bacl)paramViewHolder;
    bact localbact = (bact)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localbact != null)
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(localbact.c, null);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
        localURLDrawable.restartDownload();
      }
      localbacl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
      if (this.jdField_a_of_type_Back != null) {
        this.jdField_a_of_type_Back.a(localbacl.jdField_a_of_type_AndroidWidgetTextView);
      }
      localbacl.b.setText(a(localbact.b));
      localbacl.c.setText(b(localbact.jdField_a_of_type_Long));
      localbacl.c.setContentDescription(b(localbact.jdField_a_of_type_Long));
      localbacl.d.setText(localbact.jdField_a_of_type_JavaLangString);
      localbacl.d.setContentDescription(localbact.jdField_a_of_type_JavaLangString);
      localbacl.itemView.setOnClickListener(new bacj(this, paramInt));
      if (!this.jdField_a_of_type_Boolean) {
        break label212;
      }
      localbacl.itemView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841606));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label212:
      localbacl.itemView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841605));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new bacl(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559625, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baci
 * JD-Core Version:    0.7.0.1
 */