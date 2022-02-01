package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.avatar.utils.ApolloUtil;

public abstract interface FaceConstant$Apollo
{
  public static final int[] FACE_BG_COLOR_INDEXED = { -2611, -5427, -7983, -665107, -1190657, -2304513, -2826497 };
  public static final int[] FACE_CATEGORY_ALL = { 0, 1 };
  public static final int FACE_CATEGORY_FIGURE = 1;
  public static final String FACE_CATEGORY_FIGURE_POSTFIX = "body";
  public static final int FACE_CATEGORY_HEAD = 0;
  public static final String FACE_CATEGORY_HEAD_POSTFIX = "head";
  public static final int FACE_CLIP_SPEC_HEIGHT_2D = 80;
  public static final int FACE_CLIP_SPEC_HEIGHT_3D = 120;
  public static final int FACE_DEFAULT_SIZE_SPEC;
  public static final int FACE_REGION_HALF_FIGURE_CIRCLE_LEFT_2X = 5;
  public static final int FACE_REGION_HALF_FIGURE_CIRCLE_TOP_2X = 40;
  public static final int FACE_REGION_HALF_FIGURE_H = 60;
  public static final int FACE_REGION_HALF_FIGURE_R = 40;
  public static final int FACE_REGION_HALF_FIGURE_W = 45;
  public static final int FACE_REGION_HEAD_H = 40;
  public static final int FACE_REGION_HEAD_W = 40;
  public static final int[] FACE_SHAPE_ALL;
  public static final int[] FACE_SIZE_ALL = { 0, 1, 2 };
  public static final int FACE_SIZE_BIG = 2;
  public static final int FACE_SIZE_BIG_VALUE = 640;
  public static final int FACE_SIZE_MID = 1;
  public static final int FACE_SIZE_MID_VALUE = 140;
  public static final int FACE_SIZE_SMALL = 0;
  public static final int FACE_SIZE_SMALL_VALUE = 100;
  public static final int[] FACE_SPEC_ALL;
  public static final int FACE_TYPE_2D_AVATAR = 3;
  public static final int FACE_TYPE_3D_AVATAR = 4;
  public static final int FACE_TYPE_AVATAR_DEFAULT = 2;
  
  static
  {
    FACE_DEFAULT_SIZE_SPEC = ApolloUtil.a(0, 0);
    FACE_SPEC_ALL = ApolloUtil.a(FACE_CATEGORY_ALL, FACE_SIZE_ALL);
    FACE_SHAPE_ALL = new int[] { 0, 8, 7, 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceConstant.Apollo
 * JD-Core Version:    0.7.0.1
 */