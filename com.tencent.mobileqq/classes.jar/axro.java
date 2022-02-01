import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class axro
  extends axeu
{
  public axro(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) == null) || (NearbyPeopleProfileActivity.a(this.a) == null)) {}
    String str;
    do
    {
      return;
      NearbyPeopleProfileActivity.a(this.a).charm = paramInt3;
      NearbyPeopleProfileActivity.a(this.a).charmLevel = paramInt4;
      NearbyPeopleProfileActivity.a(this.a).curThreshold = paramInt5;
      NearbyPeopleProfileActivity.a(this.a).nextThreshold = paramInt6;
      NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("Charm", 2, "onGetCharmNotify() uin=" + this.a.app.getCurrentAccountUin());
      }
      str = bgsp.a(paramString, "<head>", "</head>");
      paramString = bgsp.a(paramString, "<body>", "</body>");
    } while (!this.a.isResume());
    bgrj.a(this.a, str, paramString, paramInt3 - paramInt1).show();
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(paramString, paramInt);
    }
    this.a.jdField_o_of_type_Int = paramInt;
  }
  
  protected void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1)
  {
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(paramBoolean, paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ongetShowLove ").append("issuccess = ").append(paramBoolean1).append(" uin = ").append(paramLong).append(" canChat = ").append(paramBoolean2).append(" can ShowLove = ").append(paramBoolean3).append("sig:").append(paramArrayOfByte).append(paramString);
    arkw.c("profileCard", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.a;
    if (this.a.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(204);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(205);
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        arkw.c(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "onGetShowLoveLimit , can chat, someting is wrong" });
        NearbyPeopleProfileActivity.a(this.a).l();
      }
    }
    for (;;)
    {
      this.a.jdField_o_of_type_Boolean = false;
      return;
      if (paramBoolean3)
      {
        if (NearbyPeopleProfileActivity.a(this.a) != null)
        {
          paramArrayOfByte = NearbyPeopleProfileActivity.a(this.a).uin;
          paramArrayOfByte = NearbyPeopleProfileActivity.a(this.a).nickname;
          int i = NearbyPeopleProfileActivity.a(this.a).gender;
          bghy.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          QLog.d("Q.nearby_people_card.", 1, "ShowLoveEditorActivity 已在725下架");
        }
      }
      else
      {
        arkw.c(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "cant show love, wording is " + paramString });
        paramArrayOfByte = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte = ((Activity)localObject).getResources().getString(2131698205);
        }
        arkw.a(this.a, paramArrayOfByte);
        continue;
        arkw.a((Activity)localObject, ((Activity)localObject).getString(2131698204));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramNearbyPeopleCard != null) && ((paramNearbyPeopleCard.tinyId == 0L) || (paramNearbyPeopleCard.tinyId != this.a.jdField_a_of_type_Long)) && ((TextUtils.isEmpty(paramNearbyPeopleCard.uin)) || ("0".equals(paramNearbyPeopleCard.uin)) || (!paramNearbyPeopleCard.uin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) && ((paramNearbyPeopleCard.nowId == 0L) || (paramNearbyPeopleCard.nowId != NearbyPeopleProfileActivity.a(this.a)))) {}
    label429:
    label469:
    label1118:
    label1136:
    do
    {
      Object localObject;
      do
      {
        return;
        this.a.a();
        localObject = bkfx.a;
        if ((localObject != null) && (((bkfx)localObject).a())) {
          ((bkfx)localObject).b(6);
        }
        if ((paramNearbyPeopleCard != null) && (QLog.isColorLevel()))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = localStringBuilder1.append("tinyid=").append(paramNearbyPeopleCard.tinyId).append(", uin=").append(paramNearbyPeopleCard.uin).append(", nickname=").append(paramNearbyPeopleCard.nickname).append(", gender=").append(paramNearbyPeopleCard.gender).append(", age=").append(paramNearbyPeopleCard.age).append(", birthday=").append(paramNearbyPeopleCard.birthday).append(", constellation=").append(paramNearbyPeopleCard.constellation).append(", distance=").append(paramNearbyPeopleCard.distance).append(", timeDiff=").append(paramNearbyPeopleCard.timeDiff).append(", photoInfoes=").append(paramNearbyPeopleCard.picInfo).append(", videoDetails=").append(paramNearbyPeopleCard.videoDetails).append(", commonLabelString=").append(paramNearbyPeopleCard.commonLabelString).append(", hiWanInfo=").append(paramNearbyPeopleCard.hiWanInfo).append(", videoInfo=").append(paramNearbyPeopleCard.videoInfo).append(", photoInfo_length=");
          if (paramNearbyPeopleCard.picList != null) {
            break;
          }
          localObject = "null";
          localStringBuilder2 = localStringBuilder2.append(localObject).append(", likeCount=").append(paramNearbyPeopleCard.likeCount).append(",likeCountInc=").append(paramNearbyPeopleCard.likeCountInc).append(", oldPhotoCount=").append(paramNearbyPeopleCard.oldPhotoCount).append(", dateInfo=").append(paramNearbyPeopleCard.dateInfo).append(", dateInfo_length=");
          if (paramNearbyPeopleCard.dateInfo != null) {
            break label1105;
          }
          localObject = "null";
          localStringBuilder2 = localStringBuilder2.append(localObject).append(", xuanYan=").append(paramNearbyPeopleCard.xuanYan).append(", xuanYan_length=");
          if (paramNearbyPeopleCard.xuanYan != null) {
            break label1118;
          }
          localObject = "null";
          localStringBuilder2.append(localObject).append(", maritalStatus=").append(paramNearbyPeopleCard.maritalStatus).append(", job=").append(paramNearbyPeopleCard.job).append(", charm=").append(paramNearbyPeopleCard.charm).append(",level=").append(paramNearbyPeopleCard.charmLevel).append(",next=").append(paramNearbyPeopleCard.nextThreshold).append(", company=").append(paramNearbyPeopleCard.company).append(", college=").append(paramNearbyPeopleCard.college).append(", hometownCountry=").append(paramNearbyPeopleCard.hometownCountry).append(", hometownProvice=").append(paramNearbyPeopleCard.hometownProvice).append(", hometownCity=").append(paramNearbyPeopleCard.hometownCity).append(", hometownDistrict=").append(paramNearbyPeopleCard.hometownDistrict).append(", bVoted=").append(paramNearbyPeopleCard.bVoted).append(", feedPreviewTime=").append(paramNearbyPeopleCard.feedPreviewTime).append(", qzoneFeed=").append(paramNearbyPeopleCard.qzoneFeed).append(", qzoneName=").append(paramNearbyPeopleCard.qzoneName).append(", qzonePicUrl_1=").append(paramNearbyPeopleCard.qzonePicUrl_1).append(", qzonePicUrl_2=").append(paramNearbyPeopleCard.qzonePicUrl_2).append(", qzonePicUrl_3=").append(paramNearbyPeopleCard.qzonePicUrl_3).append(", isPhotoUseCache=").append(paramNearbyPeopleCard.isPhotoUseCache).append(", switchQzone=").append(paramNearbyPeopleCard.switchQzone).append(", switchHobby=").append(paramNearbyPeopleCard.switchHobby).append(", uiShowControl=").append(paramNearbyPeopleCard.uiShowControl).append(", userFlag=").append(paramNearbyPeopleCard.userFlag).append(", strProfileUrl=").append(paramNearbyPeopleCard.strProfileUrl).append(", strVoteLimitedNotice=").append(paramNearbyPeopleCard.strVoteLimitedNotice).append(", bHaveVotedCnt=").append(paramNearbyPeopleCard.bHaveVotedCnt).append(", bAvailVoteCnt=").append(paramNearbyPeopleCard.bAvailVoteCnt).append(", hasStory=").append(paramNearbyPeopleCard.mHasStory);
          QLog.d("Q.nearby_people_card.", 2, "Q.nearby_people_card..onNearbyCardDownload(), isSuccess: " + paramBoolean1 + ", card = " + localStringBuilder1.toString());
        }
        if ((!paramBoolean1) || (paramNearbyPeopleCard == null)) {
          break label1136;
        }
        this.a.jdField_d_of_type_JavaLangString = paramNearbyPeopleCard.uin;
        this.a.b = true;
        this.a.a(paramNearbyPeopleCard, false, paramBoolean2);
        this.a.i();
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "onNearbyCardDownload: likeCount=" + paramNearbyPeopleCard.likeCount + ", bHaveVotedCnt=" + paramNearbyPeopleCard.bHaveVotedCnt + ", bAvailVoteCnt=" + paramNearbyPeopleCard.bAvailVoteCnt + ", bVoted=" + paramNearbyPeopleCard.bVoted);
        }
        ((axda)this.a.app.getManager(207)).a(paramNearbyPeopleCard.uin, false);
      } while (!paramNearbyPeopleCard.uin.equals(this.a.app.getCurrentAccountUin()));
      if ((paramNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(paramNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString))) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        bgsg.a(this.a, paramBoolean1);
        return;
        localObject = Integer.valueOf(paramNearbyPeopleCard.picList.size());
        break;
        localObject = Integer.valueOf(paramNearbyPeopleCard.dateInfo.length);
        break label429;
        localObject = Integer.valueOf(paramNearbyPeopleCard.xuanYan.length);
        break label469;
      }
    } while (paramBoolean2);
    label1105:
    this.a.b(anni.a(2131706020));
  }
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onEditNearbyProfileCard");
    }
    if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != this.a.jdField_a_of_type_Long) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))) {}
    while ((this.a.e != 1) && (this.a.e != 2)) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        this.a.h = true;
      }
      NearbyPeopleProfileActivity.b(this.a);
      if (this.a.t)
      {
        this.a.jdField_a_of_type_Axeq.a(true);
        this.a.t = false;
      }
      this.a.getSharedPreferences("nearby_callback", 4).edit().putInt("nearby_now_edit_profile_code_int", 0);
    }
    this.a.a(paramBoolean1, paramNearbyPeopleCard, paramBoolean2, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = (axda)this.a.app.getManager(207);
      if (NearbyPeopleProfileActivity.a(this.a) != null) {
        NearbyPeopleProfileActivity.a(this.a).h();
      }
      if ((this.a.e != 1) && (paramString.b()) && (!this.a.r) && (NearbyPeopleProfileActivity.a(this.a.j)))
      {
        this.a.r = true;
        paramString = new ImageView(this.a);
        paramString.setScaleType(ImageView.ScaleType.FIT_XY);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        this.a.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/zan.png", localURLDrawableOptions);
        if (this.a.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label157;
        }
        this.a.a(paramString, this.a.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
    return;
    label157:
    this.a.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new axrp(this, paramString));
    this.a.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (bgjw.a(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!bgjw.a(paramString2, NearbyPeopleProfileActivity.a(this.a).uin)) || (!bgjw.a(paramString1, this.a.app.getCurrentAccountUin())));
      if (!paramBoolean)
      {
        this.a.b(this.a.getResources().getString(2131693034));
        paramString1 = NearbyPeopleProfileActivity.a(this.a);
        paramString1.likeCount -= 1;
        NearbyPeopleProfileActivity.a(this.a).bVoted = 0;
        paramString1 = NearbyPeopleProfileActivity.a(this.a);
        paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt + paramInt1));
        NearbyPeopleProfileActivity.a(this.a).h();
        return;
      }
    } while (paramInt2 != 1);
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.likeCount += paramInt1;
    NearbyPeopleProfileActivity.a(this.a).bVoted = 1;
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt - paramInt1));
    if (NearbyPeopleProfileActivity.a(this.a).bAvailVoteCnt < 0) {
      NearbyPeopleProfileActivity.a(this.a).bAvailVoteCnt = 0;
    }
    NearbyPeopleProfileActivity.a(this.a).h();
  }
  
  public void a(boolean paramBoolean, String paramString1, List<axid> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onSetPersonalInterestTags");
    }
    if (paramBoolean)
    {
      this.a.a();
      this.a.a(2, anni.a(2131706025));
      return;
    }
    this.a.a();
    this.a.a(1, anni.a(2131706016) + paramString2);
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.", 2, "onUpdateNearbyPeopleAuthVideo , uint32_headid = " + paramHeadInfo.uint32_headid.get() + ", str_headurl = " + paramHeadInfo.str_headurl.get() + ", str_video_url = " + paramHeadInfo.str_video_url.get());
    }
    byte[] arrayOfByte = NearbyPeopleProfileActivity.a(this.a).vSeed;
    long l = NearbyPeopleProfileActivity.a(this.a).feedPreviewTime;
    if (this.a.jdField_a_of_type_Long > 0L) {
      bght.a(this.a.jdField_a_of_type_Axeq, this.a.app, this.a.jdField_a_of_type_Long, null, this.a.jdField_d_of_type_Int, arrayOfByte, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long, NearbyPeopleProfileActivity.a(this.a.j), NearbyPeopleProfileActivity.a(this.a), NearbyPeopleProfileActivity.a(this.a));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.update_profile", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
      }
      return;
      if (!bgsp.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        bght.a(this.a.jdField_a_of_type_Axeq, this.a.app, 0L, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.jdField_d_of_type_Int, arrayOfByte, l, true, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Long, NearbyPeopleProfileActivity.a(this.a.j), NearbyPeopleProfileActivity.a(this.a), NearbyPeopleProfileActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axro
 * JD-Core Version:    0.7.0.1
 */