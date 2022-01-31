import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.giftext.DrawableImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class bhsp
  extends RecyclerView.Adapter<bhsv>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bhsu jdField_a_of_type_Bhsu;
  private bhuq jdField_a_of_type_Bhuq;
  private bhvg jdField_a_of_type_Bhvg;
  private HashMap<String, SoftReference<bhul>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bhsf> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public bhsp(Context paramContext, List<bhsf> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((bhsf)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (bhul)((SoftReference)localObject1).get();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject2 = new File(paramString);
          if (((File)localObject2).exists())
          {
            localObject2 = ((File)localObject2).listFiles();
            if (localObject2.length > 0)
            {
              int i = 0;
              while (i < localObject2.length)
              {
                String str = String.format(paramString + "/frame_%03d.png", new Object[] { Integer.valueOf(i) });
                if (new File(str).exists()) {
                  ((ArrayList)localObject1).add(str);
                }
                i += 1;
              }
            }
          }
        }
        localObject1 = new bhul(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((bhul)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof bhul)))
        {
          ((bhul)paramImageView.getDrawable()).stop();
          paramImageView.setImageDrawable(null);
        }
        paramImageView.setImageDrawable(paramString);
        paramString.start();
        return;
      }
    }
  }
  
  private void a(AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    if (this.jdField_a_of_type_Bhuq != null)
    {
      this.jdField_a_of_type_Bhuq.a().a(this.jdField_a_of_type_Bhvg, new bhsr(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Bhuq.b().a(this.jdField_a_of_type_Bhvg, new bhss(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new bhst(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajjy.a(2131634166));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajjy.a(2131634176));
  }
  
  public bhsv a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bhsv(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492969, paramViewGroup, false));
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(bhsu parambhsu)
  {
    this.jdField_a_of_type_Bhsu = parambhsu;
  }
  
  public void a(bhsv parambhsv)
  {
    super.onViewRecycled(parambhsv);
    if ((bhsv.a(parambhsv) != null) && (bhsv.a(parambhsv).getDrawable() != null) && ((bhsv.a(parambhsv).getDrawable() instanceof bhul)))
    {
      ((bhul)bhsv.a(parambhsv).getDrawable()).stop();
      bhsv.a(parambhsv).setImageDrawable(null);
    }
  }
  
  public void a(bhsv parambhsv, int paramInt)
  {
    bhsf localbhsf = (bhsf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837655);
    localObject = baop.a("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    bhsv.a(parambhsv).setImageDrawable((Drawable)localObject);
    bhsv.a(parambhsv).setVisibility(4);
    parambhsv.a(localbhsf.a());
    switch (localbhsf.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = parambhsv.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        parambhsv.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        parambhsv.itemView.setOnClickListener(new bhsq(this, localbhsf, paramInt, parambhsv));
        return;
        bhsv.b(parambhsv).setVisibility(4);
        bhsv.a(parambhsv).setVisibility(0);
      }
    }
    bhsv.a(parambhsv).setVisibility(8);
    if (paramInt == 0)
    {
      a(bhsv.a(parambhsv));
      bhsv.a(parambhsv).setVisibility(0);
    }
    bhsv.b(parambhsv).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      parambhsv.a(true);
      if (localbhsf.jdField_a_of_type_Int == 13) {
        a(true);
      }
    }
    for (;;)
    {
      localObject = localbhsf.c;
      a(bhsv.a(parambhsv), (String)localObject, paramInt);
      break;
      parambhsv.a(false);
    }
  }
  
  public void a(bhuq parambhuq, bhvg parambhvg)
  {
    this.jdField_a_of_type_Bhuq = parambhuq;
    this.jdField_a_of_type_Bhvg = parambhvg;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsp
 * JD-Core Version:    0.7.0.1
 */