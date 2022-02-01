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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class azqd
  extends RecyclerView.Adapter<azqf>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = (int)(120.0F * PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity));
  private long jdField_a_of_type_Long;
  
  public azqd(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public azqf a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561328, paramViewGroup, false);
    return new azqf(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, paramViewGroup);
  }
  
  public void a(azqf paramazqf, int paramInt)
  {
    PersonalityLabelInfo localPersonalityLabelInfo = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.getResources().getDrawable(2131165450);
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
        paramazqf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        if (!PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity)) {
          break label418;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Azph.a(this.jdField_a_of_type_Long, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.a((azpi)localObject1, (PersonalityLabelPhoto)localPersonalityLabelInfo.personalityLabelPhotos.get(paramInt), paramazqf);
        paramazqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131372702, localObject1);
        paramazqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
        paramazqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        EventCollector.getInstance().onRecyclerBindViewHolder(paramazqf, paramInt, getItemId(paramInt));
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
        paramazqf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      else
      {
        localObject2 = new File((String)localObject2);
        try
        {
          localObject2 = new URL("file:///" + ((File)localObject2).getAbsolutePath());
          paramazqf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          localMalformedURLException2.printStackTrace();
        }
        continue;
        label418:
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
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() == 2131372702)
        {
          localObject1 = paramView.getTag();
          localObject2 = paramView.getTag(2131372702);
          if ((localObject2 == null) || (!(localObject2 instanceof azpi)) || (((azpi)localObject2).b != 3)) {
            break;
          }
          localObject1 = (azpi)localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bkzi == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bkzi = bkzi.a(paramView.getContext());
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bkzi.c("重新上传");
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bkzi.c("删除");
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bkzi.d("取消");
          }
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bkzi.a(new azqe(this, (azpi)localObject1));
          this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Bkzi.show();
        }
      }
    } while ((localObject1 == null) || (!(localObject1 instanceof Integer)));
    int m = ((Integer)localObject1).intValue();
    Object localObject3 = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity).get(Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = m;
    if (i < ((PersonalityLabelInfo)localObject3).personalityLabelPhotos.size())
    {
      PersonalityLabelPhoto localPersonalityLabelPhoto = (PersonalityLabelPhoto)((PersonalityLabelInfo)localObject3).personalityLabelPhotos.get(i);
      if (PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.jdField_a_of_type_Azph.a(this.jdField_a_of_type_Long, localPersonalityLabelPhoto);
        label295:
        if ((localObject1 == null) || (((azpi)localObject1).b != 3)) {
          break label339;
        }
        k = j;
        if (i >= m) {}
      }
      for (int k = j - 1;; k = j)
      {
        i += 1;
        j = k;
        break;
        localObject1 = null;
        break label295;
        label339:
        ((ArrayList)localObject2).add(localPersonalityLabelPhoto.getOriginUrl());
        localArrayList.add(String.valueOf(localPersonalityLabelPhoto.fileId));
      }
    }
    Object localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity, TroopAvatarWallPreviewActivity.class);
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("index", j);
    ((Bundle)localObject3).putStringArrayList("seqNum", (ArrayList)localObject2);
    ((Bundle)localObject3).putStringArrayList("photoIds", localArrayList);
    if (PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity))
    {
      bool = true;
      label437:
      ((Bundle)localObject3).putBoolean("delete_ability", bool);
      if (!PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity)) {
        break label611;
      }
    }
    label611:
    for (boolean bool = true;; bool = false)
    {
      ((Bundle)localObject3).putBoolean("SHOW_MENU", bool);
      ((Bundle)localObject3).putBoolean("IS_EDIT", false);
      ((Bundle)localObject3).putBoolean("is_use_path", true);
      ((Bundle)localObject3).putBoolean("is_show_action", false);
      ((Bundle)localObject3).putBoolean("is_not_show_index", false);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("from_personality_label", true);
      ((Bundle)localObject2).putLong("label_id", this.jdField_a_of_type_Long);
      ((Bundle)localObject3).putBundle("bundle_data_extra", (Bundle)localObject2);
      ((Intent)localObject1).putExtras((Bundle)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.startActivity((Intent)localObject1);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelGalleryActivity.app, "dc00898", "", "", "0X8007FD1", "0X8007FD1", 0, 0, "", "", "", "");
      break;
      bool = false;
      break label437;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqd
 * JD-Core Version:    0.7.0.1
 */