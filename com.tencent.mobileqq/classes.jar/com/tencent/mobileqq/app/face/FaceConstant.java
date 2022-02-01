package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap.Config;

public abstract interface FaceConstant
{
  public static final String BROADCAST_QQHEAD_GET_HEAD_REQ = "com.tencent.qqhead.getheadreq";
  public static final String BROADCAST_QQHEAD_GET_HEAD_RESP = "com.tencent.qqhead.getheadresp";
  public static final String BROADCAST_QQHEAD_REFRESH_HEAD_REQ = "com.tencent.qqhead.refreshheadreq";
  public static final String BROADCAST_QQHEAD_SELF_UPDATE = "com.tencent.qqhead.selfupdate";
  public static final long CHECK_FACE_UPDATE_PERIOD = 86400000L;
  public static final int DYNAMIC_SIZE_BIG = 640;
  public static final int DYNAMIC_SIZE_MIDDLE = 200;
  public static final int DYNAMIC_SIZE_SMALL = 100;
  public static final String EXTRA_NAME_FACEINFO_LIST = "faceInfoList";
  public static final String EXTRA_NAME_FACE_TIMESTAMP = "faceTimestamp";
  public static final String EXTRA_NAME_FORCE_REFRESH = "forceRefresh";
  public static final String EXTRA_NAME_KEYLIST = "faceKeyList";
  public static final Bitmap.Config FACE_BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  public static final byte FACE_SHAPE_APOLLO_FIGURE = 8;
  public static final byte FACE_SHAPE_APOLLO_FIGURE_HALF = 7;
  public static final byte FACE_SHAPE_APOLLO_HEAD_CIRCLE = 6;
  public static final byte FACE_SHAPE_CIRCLE = 3;
  public static final byte FACE_SHAPE_DEFAULT = 3;
  public static final byte FACE_SHAPE_DISUSSION = 3;
  public static final byte FACE_SHAPE_FORCE_CIRCLE = 4;
  public static final byte FACE_SHAPE_FORCE_SQUARE = 5;
  public static final byte FACE_SHAPE_MAX_VALUE = 5;
  public static final byte FACE_SHAPE_PUBLIC_ACCOUNT = 4;
  public static final byte FACE_SHAPE_ROUND = 2;
  public static final byte FACE_SHAPE_SQUARE = 1;
  public static final int ID_OPENID = 204;
  public static final int ID_TINYID = 202;
  public static final int ID_UIN = 200;
  public static final int MIN_ID_LEN = 5;
  public static final String PARAM_RESULT_CODE = "param_result_code";
  public static final String PARAM_RESULT_DESC = "param_result_desc";
  public static final byte QQHEAD_FILE_TYPE_DELETED = 2;
  public static final byte QQHEAD_FILE_TYPE_EXIST = 1;
  public static final byte QQHEAD_FILE_TYPE_UNKNOW = 0;
  public static final byte QQHEAD_LEVEL_FOREVER = 0;
  public static final byte QQHEAD_LEVEL_TEMPORARY = 1;
  public static final long QQHEAD_SDCARD_MIN_STORAGE_SIZE = 2048L;
  public static final long QQHEAD_SYSTEM_MIN_STORAGE_SIZE = 102400L;
  public static final int QQHEAD_TYPE_APOLLO = 116;
  public static final int QQHEAD_TYPE_DATALINE = 102;
  public static final int QQHEAD_TYPE_DEVICE = 104;
  public static final int QQHEAD_TYPE_DISUSSION = 101;
  public static final int QQHEAD_TYPE_GROUP = 4;
  public static final int QQHEAD_TYPE_GROUP_NEW = 8;
  public static final int QQHEAD_TYPE_IMAX_AD = 114;
  public static final int QQHEAD_TYPE_MERGE_KANDIAN = 111;
  public static final int QQHEAD_TYPE_MOBILE_NUMBER = 11;
  public static final int QQHEAD_TYPE_NEW_TROOP = 113;
  public static final int QQHEAD_TYPE_PSTN_DISCUSSION = 1001;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT = 115;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_ECSHOP = 106;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_SUBSCRIPT = 105;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_XIN_KANDIAN = 110;
  public static final int QQHEAD_TYPE_QCALL = 16;
  public static final int QQHEAD_TYPE_SERVICE_ACCOUNT_FOLDER = 112;
  public static final int QQHEAD_TYPE_STRANGER = 32;
  public static final int QQHEAD_TYPE_SUBACCOUNT = 103;
  public static final int QQHEAD_TYPE_USER = 1;
  public static final String QQ_HEAD_UPLOAD_ERRMSG_IMAGE_ILLEGAL = "image illegal, size must be square.";
  public static final String QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST = "file not exist";
  public static final String QQ_HEAD_UPLOAD_ERRMSG_NETWORK_ERROR = "network error";
  public static final String QQ_HEAD_UPLOAD_ERRMSG_SUCCESS = "ok";
  public static final String QQ_HEAD_UPLOAD_ERRMSG_UNKNOW_ERROR = "unkown error";
  public static final String QQ_HEAD_UPLOAD_ERRMSG_UPLOAD_FAILED = "upload failed";
  public static final int QQ_HEAD_UPLOAD_FAILEDCODE_SUCCESS = 0;
  public static final int QQ_HEAD_UPLOAD_FAILED_CODE_IMAGE_ILLEGAL = -10000;
  public static final int QQ_HEAD_UPLOAD_FAILED_CODE_NETWORK_ERROR = -10001;
  public static final int QQ_HEAD_UPLOAD_FAILED_CODE_UNKNOW_ERROR = -99999;
  public static final int QQ_HEAD_UPLOAD_FAILED_CODE_UPLOAD_FAILED = -10002;
  public static final int REQ_FACEINFO_LIST_NUM_LIMIT = 50;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION = 9204;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_FAIL = 9203;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_HTTP_RESPONSE_FAIL = 9207;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_NETWORK_FAIL = 9206;
  public static final int RESULT_CODE_QQHEAD_GET_URL_FAIL = 9201;
  public static final int RESULT_CODE_QQHEAD_SAVE_FILE_FAIL = 9202;
  public static final int RESULT_CODE_QQHEAD_STORGE_EXCEPTION = 9208;
  public static final int RESULT_CODE_QQHEAD_SUCCESS = 0;
  public static final int RESULT_CODE_QQHEAD_TIME_OUT = 9205;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceConstant
 * JD-Core Version:    0.7.0.1
 */