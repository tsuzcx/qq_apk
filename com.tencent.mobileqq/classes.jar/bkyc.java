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

public class bkyc
  extends RecyclerView.Adapter<bkyi>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bkyh jdField_a_of_type_Bkyh;
  private blad jdField_a_of_type_Blad;
  private blzb jdField_a_of_type_Blzb;
  private HashMap<String, SoftReference<bkzy>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bkxt> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  
  public bkyc(Context paramContext, List<bkxt> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Int = ((int)(DeviceUtils.getScreenWidth(paramContext) * 0.44F) + 1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ((bkxt)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
    }
  }
  
  private void a(ImageView paramImageView, String paramString, int paramInt)
  {
    Object localObject1 = (SoftReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = (bkzy)((SoftReference)localObject1).get();; localObject1 = null)
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
        localObject1 = new bkzy(this.jdField_a_of_type_AndroidContentContext, (ArrayList)localObject1, 55L);
        ((bkzy)localObject1).a(false);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new SoftReference(localObject1));
      }
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + paramInt);
        }
        if ((paramImageView.getDrawable() != null) && (paramImageView.getDrawable() != paramString) && ((paramImageView.getDrawable() instanceof bkzy)))
        {
          ((bkzy)paramImageView.getDrawable()).stop();
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
    if (this.jdField_a_of_type_Blad != null)
    {
      this.jdField_a_of_type_Blad.a().a(this.jdField_a_of_type_Blzb, new bkye(this, paramAEGIFOutlineTextView));
      this.jdField_a_of_type_Blad.b().a(this.jdField_a_of_type_Blzb, new bkyf(this, paramAEGIFOutlineTextView));
    }
    paramAEGIFOutlineTextView.setOnClickListener(new bkyg(this));
    paramAEGIFOutlineTextView.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
      if (paramBoolean) {
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(alpo.a(2131700334));
      }
    }
    else
    {
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(alpo.a(2131700344));
  }
  
  public bkyi a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bkyi(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558544, paramViewGroup, false));
  }
  
  public Set<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(bkyh parambkyh)
  {
    this.jdField_a_of_type_Bkyh = parambkyh;
  }
  
  public void a(bkyi parambkyi)
  {
    super.onViewRecycled(parambkyi);
    if ((bkyi.a(parambkyi) != null) && (bkyi.a(parambkyi).getDrawable() != null) && ((bkyi.a(parambkyi).getDrawable() instanceof bkzy)))
    {
      ((bkzy)bkyi.a(parambkyi).getDrawable()).stop();
      bkyi.a(parambkyi).setImageDrawable(null);
    }
  }
  
  public void a(bkyi parambkyi, int paramInt)
  {
    bkxt localbkxt = (bkxt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837718);
    localObject = bdpt.a("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[] { 0 }, (Drawable)localObject);
    bkyi.a(parambkyi).setImageDrawable((Drawable)localObject);
    bkyi.a(parambkyi).setVisibility(4);
    parambkyi.a(localbkxt.a());
    switch (localbkxt.jdField_a_of_type_Int)
    {
    default: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        localObject = parambkyi.itemView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
        parambkyi.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        parambkyi.itemView.setOnClickListener(new bkyd(this, localbkxt, paramInt, parambkyi));
        return;
        bkyi.b(parambkyi).setVisibility(4);
        bkyi.a(parambkyi).setVisibility(0);
      }
    }
    bkyi.a(parambkyi).setVisibility(8);
    if (paramInt == 0)
    {
      a(bkyi.a(parambkyi));
      bkyi.a(parambkyi).setVisibility(0);
    }
    bkyi.b(parambkyi).setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt)))
    {
      parambkyi.a(true);
      a(true);
    }
    for (;;)
    {
      localObject = localbkxt.c;
      a(bkyi.a(parambkyi), (String)localObject, paramInt);
      break;
      parambkyi.a(false);
    }
  }
  
  public void a(blad paramblad, blzb paramblzb)
  {
    this.jdField_a_of_type_Blad = paramblad;
    this.jdField_a_of_type_Blzb = paramblzb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyc
 * JD-Core Version:    0.7.0.1
 */