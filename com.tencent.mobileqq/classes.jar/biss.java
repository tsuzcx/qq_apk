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
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class biss
  extends RecyclerView.Adapter<bisy>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bisx jdField_a_of_type_Bisx;
  private bius jdField_a_of_type_Bius;
  private bjnb jdField_a_of_type_Bjnb;
  private HashMap<String, SoftReference<biun>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bisj> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public biss(Context paramContext, List<bisj> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((bisj)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (biun)((SoftReference)localObject1).get();; localObject1 = null)
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
        localObject1 = new biun(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((biun)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof biun)))
        {
          ((biun)paramImageView.getDrawable()).stop();
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
    if (this.jdField_a_of_type_Bius != null)
    {
      this.jdField_a_of_type_Bius.a().a(this.jdField_a_of_type_Bjnb, new bisu(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Bius.b().a(this.jdField_a_of_type_Bjnb, new bisv(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new bisw(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajyc.a(2131699954));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajyc.a(2131699964));
  }
  
  public bisy a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bisy(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558520, paramViewGroup, false));
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(bisx parambisx)
  {
    this.jdField_a_of_type_Bisx = parambisx;
  }
  
  public void a(bisy parambisy)
  {
    super.onViewRecycled(parambisy);
    if ((bisy.a(parambisy) != null) && (bisy.a(parambisy).getDrawable() != null) && ((bisy.a(parambisy).getDrawable() instanceof biun)))
    {
      ((biun)bisy.a(parambisy).getDrawable()).stop();
      bisy.a(parambisy).setImageDrawable(null);
    }
  }
  
  public void a(bisy parambisy, int paramInt)
  {
    bisj localbisj = (bisj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837664);
    localObject = bbql.a("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    bisy.a(parambisy).setImageDrawable((Drawable)localObject);
    bisy.a(parambisy).setVisibility(4);
    parambisy.a(localbisj.a());
    switch (localbisj.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = parambisy.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        parambisy.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        parambisy.itemView.setOnClickListener(new bist(this, localbisj, paramInt, parambisy));
        return;
        bisy.b(parambisy).setVisibility(4);
        bisy.a(parambisy).setVisibility(0);
      }
    }
    bisy.a(parambisy).setVisibility(8);
    if (paramInt == 0)
    {
      a(bisy.a(parambisy));
      bisy.a(parambisy).setVisibility(0);
    }
    bisy.b(parambisy).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      parambisy.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localbisj.c;
      a(bisy.a(parambisy), (String)localObject, paramInt);
      break;
      parambisy.a(false);
    }
  }
  
  public void a(bius parambius, bjnb parambjnb)
  {
    this.jdField_a_of_type_Bius = parambius;
    this.jdField_a_of_type_Bjnb = parambjnb;
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
 * Qualified Name:     biss
 * JD-Core Version:    0.7.0.1
 */