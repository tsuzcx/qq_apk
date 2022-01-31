import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class auua
  extends RecyclerView.Adapter<auuc>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = (int)(120.0F * PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity));
  private long jdField_a_of_type_Long;
  
  public auua(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public auuc a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560941, paramViewGroup, false);
    return new auuc(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, paramViewGroup);
  }
  
  public void a(auuc paramauuc, int paramInt)
  {
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.getResources().getDrawable(2131165367);
    }
    Object localObject1 = ((PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt)).localThumbPath;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = new File((String)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = new URL("file:///" + ((File)localObject1).getAbsolutePath());
        paramauuc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        if (!PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity)) {
          break label405;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Autd.a(this.jdField_a_of_type_Long, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a((aute)localObject1, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt), paramauuc);
        paramauuc.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131371519, localObject1);
        paramauuc.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
        paramauuc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        return;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        localMalformedURLException1.printStackTrace();
        continue;
      }
      Object localObject2 = ((PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt)).get350SizeUrl();
      if ((((String)localObject2).startsWith("http")) || (((String)localObject2).startsWith("https")))
      {
        localObject2 = URLDrawable.getDrawable((String)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramauuc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      else
      {
        localObject2 = new File((String)localObject2);
        try
        {
          localObject2 = new URL("file:///" + ((File)localObject2).getAbsolutePath());
          paramauuc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          localMalformedURLException2.printStackTrace();
        }
        continue;
        label405:
        Object localObject3 = null;
      }
    }
  }
  
  public int getItemCount()
  {
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
    if ((localPersonalityLabelInfo != null) && (localPersonalityLabelInfo.personalityLabelPhotos != null)) {
      return localPersonalityLabelInfo.personalityLabelPhotos.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.b) {}
    do
    {
      do
      {
        return;
      } while (paramView.getId() != 2131371519);
      localObject1 = paramView.getTag();
      localObject2 = paramView.getTag(2131371519);
      if ((localObject2 != null) && ((localObject2 instanceof aute)) && (((aute)localObject2).b == 3))
      {
        localObject1 = (aute)localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bfpc == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bfpc = bfpc.a(paramView.getContext());
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bfpc.c("重新上传");
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bfpc.c("删除");
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bfpc.d("取消");
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bfpc.a(new auub(this, (aute)localObject1));
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bfpc.show();
        return;
      }
    } while ((localObject1 == null) || (!(localObject1 instanceof Integer)));
    int m = ((Integer)localObject1).intValue();
    Object localObject3 = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    int i = 0;
    int j = m;
    if (i < ((PersonalityLabelInfo)localObject3).personalityLabelPhotos.size())
    {
      PersonalityLabelPhoto localPersonalityLabelPhoto = (PersonalityLabelPhoto)((PersonalityLabelInfo)localObject3).personalityLabelPhotos.get(i);
      if (PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Autd.a(this.jdField_a_of_type_Long, localPersonalityLabelPhoto);
        label282:
        if ((paramView == null) || (paramView.b != 3)) {
          break label323;
        }
        k = j;
        if (i >= m) {}
      }
      for (int k = j - 1;; k = j)
      {
        i += 1;
        j = k;
        break;
        paramView = null;
        break label282;
        label323:
        ((ArrayList)localObject1).add(localPersonalityLabelPhoto.getOriginUrl());
        ((ArrayList)localObject2).add(String.valueOf(localPersonalityLabelPhoto.fileId));
      }
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, TroopAvatarWallPreviewActivity.class);
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("index", j);
    ((Bundle)localObject3).putStringArrayList("seqNum", (ArrayList)localObject1);
    ((Bundle)localObject3).putStringArrayList("photoIds", (ArrayList)localObject2);
    if (PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity))
    {
      bool = true;
      ((Bundle)localObject3).putBoolean("delete_ability", bool);
      if (!PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity)) {
        break label590;
      }
    }
    label590:
    for (boolean bool = true;; bool = false)
    {
      ((Bundle)localObject3).putBoolean("SHOW_MENU", bool);
      ((Bundle)localObject3).putBoolean("IS_EDIT", false);
      ((Bundle)localObject3).putBoolean("is_use_path", true);
      ((Bundle)localObject3).putBoolean("is_show_action", false);
      ((Bundle)localObject3).putBoolean("is_not_show_index", false);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("from_personality_label", true);
      ((Bundle)localObject1).putLong("label_id", this.jdField_a_of_type_Long);
      ((Bundle)localObject3).putBundle("bundle_data_extra", (Bundle)localObject1);
      paramView.putExtras((Bundle)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.startActivity(paramView);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.app, "dc00898", "", "", "0X8007FD1", "0X8007FD1", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auua
 * JD-Core Version:    0.7.0.1
 */